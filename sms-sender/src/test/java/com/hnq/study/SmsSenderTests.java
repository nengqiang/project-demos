package com.hnq.study;

import com.hnq.study.config.SmsConfig;
import com.hnq.study.service.SmsSendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author henengqiang
 * @date 2018/9/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmsSenderApplication.class)
public class SmsSenderTests {

    @Autowired
    private SmsConfig smsConfig;

    @Autowired
    private SmsSendService smsSendService;

    @Test
    public void configTest() {
        System.out.println(smsConfig);
    }

    @Test
    public void smsSendTest() {
        smsSendService.sendSMS();
    }

}
