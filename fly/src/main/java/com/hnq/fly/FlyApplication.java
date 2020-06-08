package com.hnq.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
@SpringBootApplication
@ImportResource(value = "classpath:spring/appContext.xml")
public class FlyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlyApplication.class);
    }

}
