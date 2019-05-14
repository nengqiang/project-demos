package com.hnq.study;

import com.hnq.study.config.MailConfig;
import com.hnq.study.service.JavaMailService;
import com.hnq.study.utils.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @author henengqiang
 * @date 2018/9/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MailSenderApp.class)
public class MailSenderTests {

    @Autowired
    private MailConfig mailConfig;

    @Autowired
    private JavaMailService javaMailService;

    @Test
    public void configTest() {
        System.out.println(mailConfig);
    }

    @Test
    public void javaMailSendTest() {
        try {
            String subject = "哈哈哈，测一次😂";
            String message = FileUtils.read(
                    "src" + File.separator +
                            "main" + File.separator +
                            "java" + File.separator +
                            "com" + File.separator +
                            "hnq" + File.separator +
                            "study" + File.separator +
                            "service" + File.separator +
                            "JavaMailService.java", "<br>"
            );
            javaMailService.sendEmail(subject, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
