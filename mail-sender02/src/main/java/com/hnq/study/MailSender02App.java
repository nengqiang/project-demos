package com.hnq.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author henengqiang
 * @date 2019/05/14
 */
@SpringBootApplication
@Slf4j
public class MailSender02App {

    public static void main(String[] args) {
        SpringApplication.run(MailSender02App.class);
        log.info(">>> MailSender02App Start Success!");
    }

}
