package com.hnq.crawler.controller;

import com.hnq.crawler.service.BaiduHotDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author henengqiang
 * @date 2018/9/1
 */
@RestController
@RequestMapping(value = "/crawler")
public class ManualControlController {

    @Autowired
    private BaiduHotDownService baiduHotDownService;

    @RequestMapping(value = "/downHot0")
    public String manualDownHot0() {
        try {
            baiduHotDownService.downBaiduHot0();
        } catch (Exception e) {
            return String.format("爬取页面数据出错：%s", e);
        }
        return "爬取页面数据成功";
    }

    @RequestMapping(value = "/downStock")
    public String manualDownStock() {
        try {
            baiduHotDownService.downStockPrice();
        } catch (Exception e) {
            return String.format("获取Stock数据出错：%s", e);
        }
        return "获取Stock数据成功";
    }

    @RequestMapping(value = "downHot1")
    public String manualDownHot1() {
        try {
            baiduHotDownService.downBaiduHot1();
        } catch (Exception e) {
            return String.format("爬取页面数据出错：%s", e);
        }
        return "爬取页面数据成功";
    }

}
