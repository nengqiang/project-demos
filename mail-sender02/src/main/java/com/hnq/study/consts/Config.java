package com.hnq.study.consts;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author henengqiang
 * @date 2019/05/14
 */
@Configuration
@Data
public class Config {

    @Value("${mail.fromMail.addr}")
    private String fromAddr;

    @Value("${mail.toMail.addrs}")
    private String toAddrs;

}
