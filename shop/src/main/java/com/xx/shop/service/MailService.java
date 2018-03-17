package com.xx.shop.service;


import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

public interface MailService {
    static final String HOST = "smtp.qq.com";
//    static final Integer PORT = 25;
    static final String USERNAME = "1018429593@qq.com";
    static final String PASSWORD = "xlyucukyfpvlbffh";
//    static final String EMAILFORM = "15953185712@163.com";
    static JavaMailSenderImpl mailSender = createMailSender();


    static JavaMailSenderImpl createMailSender(){
        return new JavaMailSenderImpl();
    }

    /**
     * 发送邮件内容
     * @param content
     */
    public void send(String e_mail,String title, String content);

}
