package com.hnq.study.service;

/**
 * @author henengqiang
 * @date 2019/05/14
 */
public interface IMailService {

    /**
     * 发送文本邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleMail(String[] to, String subject, String content);

    /**
     * 发送html邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String[] to, String subject, String content);

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    void sendAttachmentMail(String[] to, String subject, String content, String filePath);

    /**
     * 发送正文中有静态资源（图片）的邮件
     * @param to
     * @param subject
     * @param content
     * @param srcPath
     * @param srcId
     */
    void sendInlineResourceMail(String[] to, String subject, String content, String srcPath, String srcId);

}
