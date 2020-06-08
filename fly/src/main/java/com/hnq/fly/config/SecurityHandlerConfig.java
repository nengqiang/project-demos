package com.hnq.fly.config;

import com.alibaba.fastjson.JSONObject;
import com.hnq.fly.filter.TokenFilter;
import com.hnq.fly.model.bo.LoginUser;
import com.hnq.fly.model.bo.Token;
import com.hnq.fly.model.response.ResponseInfo;
import com.hnq.fly.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * spring security 处理器
 *
 * @author henengqiang
 * @date 2020/5/25
 */
@Configuration
@Slf4j
public class SecurityHandlerConfig {

    @Autowired
    private TokenService tokenService;

    /**
     * 登陆成功，返回 token
     */
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return (request, response, authentication) -> {
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();

            Token token = tokenService.saveToken(loginUser);
            responseJson(response, HttpStatus.SC_OK, token);
        };
    }

    /**
     * 登录失败，返回401
     */
    @Bean
    public AuthenticationFailureHandler loginFailureHandler() {
        return (request, response, exception) -> {
            String msg = exception instanceof BadCredentialsException ? "密码错误" : exception.getMessage();
            ResponseInfo info = new ResponseInfo(String.valueOf(HttpStatus.SC_UNAUTHORIZED), msg);
            responseJson(response, HttpStatus.SC_UNAUTHORIZED, info);
        };
    }

    /**
     * 未登录，返回401
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> {
            ResponseInfo info = new ResponseInfo(String.valueOf(HttpStatus.SC_UNAUTHORIZED), "请先登录");
            responseJson(response, HttpStatus.SC_UNAUTHORIZED, info);
        };
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) -> {
            ResponseInfo info = new ResponseInfo(String.valueOf(HttpStatus.SC_OK), "退出成功");

            String token = TokenFilter.getToken(request);
            tokenService.deleteToken(token);

            responseJson(response, HttpStatus.SC_OK, info);
        };
    }

    private void responseJson(HttpServletResponse response, int status, Object data) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");

            response.getWriter().write(JSONObject.toJSONString(data));
        } catch (Exception e) {
            log.error("返回响应异常：", e);
        }
    }

}
