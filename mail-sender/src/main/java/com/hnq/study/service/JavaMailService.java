package com.hnq.study.service;

import com.hnq.study.config.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * 使用 JavaMail 发送邮件
 * 
 * @author henengqiang
 * @date 2018/9/4
 */
@Service
public class JavaMailService {

    @Autowired
    private MailConfig mailConfig;

    public void sendEmail(String emailSubject, String emailMsg) {
        try {
            // 1.创建一个程序与邮件服务器会话对象 Session
            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", "SMTP");
            props.setProperty("mail.smtp.host", mailConfig.getHost());
            props.setProperty("mail.smtp.port", mailConfig.getPort().toString());
            // 指定验证为true
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.timeout", mailConfig.getTimeout());
            // 验证账号及密码，163邮箱需要的是第三方授权码
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailConfig.getAccount(), mailConfig.getPassword());
                }
            };
            Session session = Session.getInstance(props, auth);

            // 2.创建一个 Message，它相当于是邮件内容
            Message message = new MimeMessage(session);
            // 设置发送者
            message.setFrom(new InternetAddress(mailConfig.getEmailFrom()));

            // 设置多个收件人地址
            List<String> recipients = mailConfig.getEmailRecipients();
            Address[] addresses = getAddress(recipients);

            // 设置发送方式与接收者
            message.setRecipients(MimeMessage.RecipientType.TO, addresses);
            // 设置主题
            message.setSubject(emailSubject);
            // 设置内容
            message.setContent(emailMsg, "text/html;charset=utf-8");

            // 3.创建 Transport 用于发送邮件
            Transport.send(message);
            System.out.println("邮件发送成功！Sender: " + mailConfig.getEmailFrom() + ", Recipients: " + mailConfig.getEmailRecipient());
            System.out.println("Subject: " + emailSubject + ", Message: " + emailMsg);
        } catch (Exception e) {
            throw new RuntimeException("邮件发送失败！");
        }
    }

    private Address[] getAddress(List<String> recipients) throws AddressException {
        Address[] addresses = new Address[recipients.size()];
        for (int i = 0; i < recipients.size(); i++) {
            addresses[i] = new InternetAddress(recipients.get(i));
        }
        return addresses;
    }
    
}
