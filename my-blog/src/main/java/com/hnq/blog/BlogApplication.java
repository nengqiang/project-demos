package com.hnq.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author henengqiang
 * @date 2018/9/30
 */
@SpringBootApplication
@ImportResource(value = {"classpath:/spring/appContext.xml"})
public class BlogApplication {

    private static final Logger logger = LoggerFactory.getLogger(BlogApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class);
        logger.info("==========>> BlogApplication Start Success!");
    }

}
