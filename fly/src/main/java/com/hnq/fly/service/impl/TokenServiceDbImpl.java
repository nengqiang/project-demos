package com.hnq.fly.service.impl;

import com.hnq.fly.model.bo.LoginUser;
import com.hnq.fly.model.bo.Token;
import com.hnq.fly.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * token 存到数据库的实现类
 *
 * @author henengqiang
 * @date 2020/3/18
 */
@Service
@Slf4j
public class TokenServiceDbImpl implements TokenService {
    @Override
    public Token saveToken(LoginUser loginUser) {
        return null;
    }

    @Override
    public void refresh(LoginUser loginUser) {

    }

    @Override
    public LoginUser getLoginUser(String token) {
        return null;
    }

    @Override
    public boolean deleteToken(String token) {
        return false;
    }
}
