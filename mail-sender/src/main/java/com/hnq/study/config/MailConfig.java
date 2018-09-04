package com.hnq.study.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/4
 */
@Configuration
public class MailConfig {

    @Value("${mailHost}")
    private String host;

    @Value("${mailPort}")
    private Integer port;

    @Value("${mailAccount}")
    private String account;

    @Value("${mailPassword}")
    private String password;

    @Value("${mailTimeout}")
    private String timeout;

    @Value("${mailFrom}")
    private String emailFrom;

    @Value("${mailRecipient}")
    private String emailRecipient;

    private String personal = "HANIF";

    @Override
    public String toString() {
        return "EmailConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", timeout='" + timeout + '\'' +
                ", emailFrom='" + emailFrom + '\'' +
                ", emailRecipient='" + emailRecipient + '\'' +
                ", personal='" + personal + '\'' +
                '}';
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailRecipient() {
        return emailRecipient;
    }

    public void setEmailRecipient(String emailRecipient) {
        this.emailRecipient = emailRecipient;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public List<String> getEmailRecipients() {
        return Arrays.asList(emailRecipient.split(","));
    }

}
