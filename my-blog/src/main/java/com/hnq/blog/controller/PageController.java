package com.hnq.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author henengqiang
 * @date 2018/10/17
 */
@Controller
@RequestMapping(value = "/page")
public class PageController {

    @RequestMapping(value = "/index")
    public ModelAndView toIndex() {
        return new ModelAndView("pages/index");
    }

}