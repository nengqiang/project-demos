package com.hnq.study.service.impl;

import com.hnq.study.consts.Config;
import com.hnq.study.service.IMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author henengqiang
 * @date 2019/05/14
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {

    @Autowired
    private Config config;

    @Autowired
    private IMailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void templateMailTest() {
        String subject = "主题：这是模板邮件";
        Context context = new Context();
        context.setVariable("id", "12315");
        String emailContent = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlMail(config.getToAddrs().split(","), subject, emailContent);
    }

    @Test
    public void simpleMailTest() {
        String subject = "Simple Mail Test";
        String content = "Hello:\n\tThis is a simple mail.";
        mailService.sendSimpleMail(config.getToAddrs().split(","), subject, content);
    }

    @Test
    public void htmlMailTest() {
        String subject = "Html Mail Test";
        String content = "<html><body><h3>Hello:</h3><br/>&nbsp;&nbsp;<h4>This is a <b><i>html</i></b> Mail.</h4></body></html>";
        mailService.sendHtmlMail(config.getToAddrs().split(","), subject, content);
    }

    @Test
    public void attachmentMailTest() {
        String filePath = "/Users/hanif/github/project-demos/mail-sender02/src/main/resources/templates/emailTemplate.html";
        String subject = "主题：带附件的邮件";
        String content = "有附件，请查收！\n";
        mailService.sendAttachmentMail(config.getToAddrs().split(","), subject, content, filePath);
    }

    @Test
    public void inlineMailTest() {
        String srcId = "12315";
        String subject = "主题：这是有图片的邮件";
        String content = "<html><body>这是有图片的邮件：<img src='cid:" + srcId + "'></body></html>";
        String imgPath = "/Users/hanif/github/project-demos/mail-sender02/src/main/resources/5cb43db4440f5.jpg";
        mailService.sendInlineResourceMail(config.getToAddrs().split(","), subject, content, imgPath, srcId);
    }

}