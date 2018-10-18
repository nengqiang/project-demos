package com.hnq.blog.controller;

import com.alibaba.fastjson.JSON;
import com.hnq.blog.bean.Answer;
import com.hnq.blog.dao.domain.Role;
import com.hnq.blog.dao.domain.User;
import com.hnq.blog.service.ILoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author henengqiang
 * @date 2018/9/30
 */
@Controller
@RequestMapping(value = "/back")
public class LoginController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ILoginService loginService;

    /**
     * 用户登陆
     */
    @RequestMapping(value = "/loginUser")
    public ModelAndView loginUser(@RequestParam("userName") String userName,
                                  @RequestParam("password") String password,
                                  HttpSession session) {
        // 把前端输入的 userName 和 password 封装为 token
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            session.setAttribute("user", subject.getPrincipal());
            List<Role> roles = loginService.findUserRolesPermissionsByName(userName).getRoles();
            for (Role role : roles) {
                if ("admin".equals(role.getRoleName())) {
                    return new ModelAndView("backstage/admin");
                }
            }
            return new ModelAndView("backstage/dashboard");
        } catch (Exception e){
            return new ModelAndView("backstage/login")
                    .addObject("errorMsg", "登陆失败！");
        }
    }

    /**
     * 访问 login 时跳转到登陆页面
     */
    @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("backstage/login");
    }

    /**
     * 普通管理员注册
     */
    @RequestMapping(value = "/regist")
    @ResponseBody
    public Answer<?> regist(@RequestParam("userName") String userName,
                         @RequestParam("password") String password,
                         HttpSession session) {
        try {
            User user = loginService.regist(userName, password);
            logger.info("注册成功，user={}", JSON.toJSONString(user));
            session.setAttribute("user", user);
            return renderAnswer("注册成功。", "用户名：" + userName);
        } catch (Exception e) {
            return renderError("注册失败！", e.getMessage());
        }
    }

    /**
     * 未登陆授权的提示页面
     */
    @RequestMapping(value = "/unauthorized")
    public ModelAndView unauthorized() {
        return new ModelAndView("backstage/unauthorized");
    }

}
