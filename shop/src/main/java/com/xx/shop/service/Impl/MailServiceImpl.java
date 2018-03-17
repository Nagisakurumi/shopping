package com.xx.shop.service.Impl;

import com.xx.shop.service.MailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {

    @Override
    public void send(String e_mail,String title, String content) {
        //创建邮件发送服务器
        mailSender.setHost(HOST);
        mailSender.setUsername(USERNAME);
        mailSender.setPassword(PASSWORD);
        //加认证机制
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.timeout", 5000);
        mailSender.setJavaMailProperties(properties);

        //创建邮件内容
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(USERNAME);
        message.setTo(e_mail);
        message.setSubject(title);
        message.setText(content);
        //发送邮件
        mailSender.send(message);
    }
}
