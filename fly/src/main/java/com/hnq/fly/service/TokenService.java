package com.hnq.fly.service;

import com.hnq.fly.model.bo.LoginUser;
import com.hnq.fly.model.bo.Token;

/**
 * Token 管理器
 * 可存储到 redis 或 数据库
 *
 * @author henengqiang
 * @date 2020/3/16
 */
public interface TokenService {

    Token saveToken(LoginUser loginUser);

    void refresh(LoginUser loginUser);

    LoginUser getLoginUser(String token);

    boolean deleteToken(String token);

}
