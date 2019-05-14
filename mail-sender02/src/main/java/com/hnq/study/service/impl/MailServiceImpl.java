package com.hnq.study.service.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hnq.study.consts.Config;
import com.hnq.study.service.IMailService;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author henengqiang
 * @date 2019/05/14
 */
@Service
@Slf4j
public class MailServiceImpl implements IMailService {

    @Autowired
    private Config config;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMail(String[] to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(config.getFromAddr());
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            log.info(">>> 简单邮件已发送，收件人={}", config.getToAddrs());
        } catch (Exception e) {
            log.error(">>> 简单邮件发送失败：", e);
        }
    }

    @Override
    public void sendHtmlMail(String[] to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            // true表示需要新建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(config.getFromAddr());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            log.info(">>> html邮件已发送，收件人={}", config.getToAddrs());
        } catch (Exception e) {
            log.error(">>> html邮件发送失败：", e);
        }
    }

    @Override
    public void sendAttachmentMail(String[] to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(config.getFromAddr());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            mailSender.send(message);
            log.info(">>> 带附件的邮件已发送，收件人={}", config.getToAddrs());
        } catch (Exception e) {
            log.error(">>> 带附件的邮件发送失败：", e);
        }
    }

    @Override
    public void sendInlineResourceMail(String[] to, String subject, String content, String srcPath, String srcId) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(config.getFromAddr());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(srcPath));
            helper.addInline(srcId, res);

            mailSender.send(message);
            log.info(">>> 嵌入静态资源的邮件已发送，收件人={}", config.getToAddrs());
        } catch (Exception e) {
            log.error(">>> 嵌入静态资源的邮件发送失败：", e);
        }
    }

}
