package com.hnq.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author henengqiang
 * @date 2018/9/4
 */
@SpringBootApplication
public class MailSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailSenderApplication.class);
        System.out.println("==========>>EmailSenderApplication Start Success!");
    }

}
