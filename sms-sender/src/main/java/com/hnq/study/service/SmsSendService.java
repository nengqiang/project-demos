package com.hnq.study.service;

import com.hnq.study.config.SmsConfig;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 *  短信发送后返回值       说　明
 *    -1                 没有该用户账户
 *    -2                 接口密钥不正确，秘钥不是账户登陆密码
 *    -21                MD5接口密钥加密不正确
 *    -3                 短信数量不足
 *    -11                该用户被禁用
 *    -14                短信内容出现非法字符
 *    -4                 手机号格式不正确
 *    -41                手机号码为空
 *    -42                短信内容为空
 *    -51                短信签名格式不正确，接口签名格式为：【签名内容】
 *    -6                 IP限制
 *    大于0              短信发送数量
 *
 * @author henengqiang
 * @date 2018/9/5
 */
@Service
public class SmsSendService {

    @Autowired
    private SmsConfig smsConfig;

    public void sendSMS() {
        try {
            HttpClient httpClient = new HttpClient();
            PostMethod post = new PostMethod(smsConfig.getPostMethodUrl());
            // 在头文件中设置转码
            post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            NameValuePair[] data = {
                // 注册的用户名
                new NameValuePair("Uid", smsConfig.getUid()),
                // 注册成功后，登录网站修改的密钥
                new NameValuePair("key", smsConfig.getKey()),
                new NameValuePair("smsMob", smsConfig.getPhoneNumber()),
                // 短信内容 发送短信时请在内容后加签名：【XX公司或XX网名称】，否者会被屏蔽。
                new NameValuePair("smsText", "花费了我的一条短信数量用Java代码给你发来验证码：8809【大树网络】")
            };
            post.setRequestBody(data);
            httpClient.executeMethod(post);
            Header[] headers = post.getRequestHeaders();
            int statusCode = post.getStatusCode();
            System.out.println("StatusCode: " + statusCode);
            for (Header header : headers) {
                System.out.println(header.toString());
            }
            String result = new String(post.getResponseBodyAsString().getBytes(StandardCharsets.UTF_8));
            System.out.println("返回值：" + result);
            post.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
