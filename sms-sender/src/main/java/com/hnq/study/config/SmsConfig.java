package com.hnq.study.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author henengqiang
 * @date 2018/9/5
 */
@Configuration
public class SmsConfig {

    /** 接口地址 */
    @Value("${postMethodUrl}")
    private String postMethodUrl;

    /** 注册的用户名 */
    @Value("${uid}")
    private String uid;

    /** 注册成功后，登录网站修改的密钥 */
    @Value("${key}")
    private String key;

    /** 手机号码 */
    @Value("${phoneNumber}")
    private String phoneNumber;

    @Override
    public String toString() {
        return "SmsConfig{" +
                "postMethodUrl='" + postMethodUrl + '\'' +
                ", uid='" + uid + '\'' +
                ", key='" + key + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getPostMethodUrl() {
        return postMethodUrl;
    }

    public void setPostMethodUrl(String postMethodUrl) {
        this.postMethodUrl = postMethodUrl;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
