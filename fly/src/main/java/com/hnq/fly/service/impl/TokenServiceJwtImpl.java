package com.hnq.fly.service.impl;

import com.hnq.fly.enums.ModuleEnum;
import com.hnq.fly.model.bo.SysLogBO;
import com.hnq.fly.model.bo.LoginUser;
import com.hnq.fly.model.bo.Token;
import com.hnq.fly.service.SysLogService;
import com.hnq.fly.service.TokenService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * token 存到 redis 的实现类<br>
 * jwt 实现的 token
 *
 * @author henengqiang
 * @date 2020/3/18
 */
@Primary
@Service
@Slf4j
public class TokenServiceJwtImpl implements TokenService {

    @Value("${token.expire.seconds}")
    private Integer expireSeconds;

    @Value("${token.jwtSecret}")
    private String jwtSecret;

    private static Key key = null;

    private static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";

    private static final String NULL = "null";

    @Resource
    private RedisTemplate<String, LoginUser> redisTemplate;

    @Autowired
    private SysLogService logService;

    @Override
    public Token saveToken(LoginUser loginUser) {
        loginUser.setToken(UUID.randomUUID().toString());
        cacheLoginUser(loginUser);
        // 登录日志
        logService.saveLog(loginUser.getUserNo(), ModuleEnum.LOGIN.getZhDesc(), SysLogBO.Status.SUCCESS, null);

        String jwtToken = createJwtToken(loginUser);

        return new Token(jwtToken, loginUser.getLoginTime());
    }

    @Override
    public void refresh(LoginUser loginUser) {
        cacheLoginUser(loginUser);
    }

    @Override
    public LoginUser getLoginUser(String token) {
        String uuid = getUuidFromJwt(token);
        return uuid == null ? null : redisTemplate.boundValueOps(getTokenKey(uuid)).get();
    }

    @Override
    public boolean deleteToken(String token) {
        String uuid = getUuidFromJwt(token);
        if (uuid != null) {
            String key = getTokenKey(uuid);
            LoginUser loginUser = redisTemplate.opsForValue().get(key);
            if (loginUser != null) {
                redisTemplate.delete(key);
                // 退出日志
                logService.saveLog(loginUser.getUserNo(), ModuleEnum.EXIT.getZhDesc(), SysLogBO.Status.SUCCESS, null);
                return true;
            }
        }
        return false;
    }

    private String getUuidFromJwt(String token) {
        if (NULL.equals(token) || StringUtils.isBlank(token)) {
            return null;
        }

        try {
            Map<String, Object> jwtClaims = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJwt(token).getBody();
            return MapUtils.getString(jwtClaims, LOGIN_USER_KEY);
        } catch (ExpiredJwtException e) {
            log.error("{}已过期", token);
        } catch (Exception e) {
            log.error("获取key异常", e);
        }
        return null;
    }

    /**
     * 生成 jwt
     */
    private String createJwtToken(LoginUser loginUser) {
        Map<String, Object> claims = new HashMap<>(16);
        // 放入一个随机字符串，通过该串可以找到登录用户
        claims.put(LOGIN_USER_KEY, loginUser.getToken());
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, getKeyInstance()).compact();
    }

    private Key getKeyInstance() {
        if (key == null) {
            synchronized (TokenServiceJwtImpl.class) {
                if (key == null) {
                    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtSecret);
                    key = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
                }
            }
        }
        return key;
    }

    private void cacheLoginUser(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + expireSeconds * 1000);
        redisTemplate.boundValueOps(getTokenKey(loginUser.getToken())).set(loginUser, expireSeconds, TimeUnit.SECONDS);
    }

    private String getTokenKey(String uuid) {
        return "token:" + uuid;
    }

}
