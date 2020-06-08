package com.hnq.fly.filter;

import com.hnq.fly.model.bo.LoginUser;
import com.hnq.fly.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token 过滤器
 *
 * @author henengqiang
 * @date 2020/5/18
 */
@Component
public class TokenFilter extends OncePerRequestFilter {

    private static final String TOKEN_KEY = "token";

    private static final Long MINUTES_10 = 10 * 60 * 1000L;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);
        if (StringUtils.isNotBlank(token)) {
            LoginUser loginUser = tokenService.getLoginUser(token);
            if (loginUser != null) {
                loginUser = checkLoginTime(loginUser);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                loginUser, null, loginUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }

    /**
     * 根据 parameter 或 header 获取 token
     */
    public static String getToken(HttpServletRequest request) {
        return StringUtils.defaultIfBlank(request.getParameter(TOKEN_KEY), request.getHeader(TOKEN_KEY));
    }

    /**
     * 校验登录时间<br>
     * 过期时间与当前时间对比，临近过期10分钟以内的话，自动刷新缓存
     */
    private LoginUser checkLoginTime(LoginUser loginUser) {
        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MINUTES_10) {
            String token = loginUser.getToken();
            loginUser = (LoginUser) userDetailsService.loadUserByUsername(loginUser.getUsername());
            loginUser.setToken(token);
            tokenService.refresh(loginUser);
        }
        return loginUser;
    }

}
