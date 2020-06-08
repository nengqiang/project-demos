package com.hnq.fly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author henengqiang
 * @date 2020/5/25
 */
@Controller
public class LoginPageController {

    @RequestMapping("/")
    public RedirectView loginPage() {
        return new RedirectView("/login.html");
    }

}
