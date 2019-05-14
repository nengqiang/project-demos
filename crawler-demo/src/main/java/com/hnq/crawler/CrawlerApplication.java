package com.hnq.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author henengqiang
 * @date 2018/8/30
 */
@SpringBootApplication
@ImportResource(value = {"classpath:spring/appContext.xml"})
@EnableScheduling
public class CrawlerApplication {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CrawlerApplication.class);
        logger.info("==========>> CrawlerApplication启动成功 <<==========");
    }

}
