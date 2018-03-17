package com.xx.shop.controller;


import com.xx.shop.entity.UserInfo;
import com.xx.shop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 用于的sessionkey
     */
    private final static String userSessionName = "userinfo";

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Object> login(String username, String password){
        Map<String, Object> model = new HashMap<>();
//        if(username == "1" && password == "1"){
        if(userInfoService.isSureUser(username, password) == true){
            model.put("success", "true");
//            session.setAttribute(userSessionName,username);
        }else{
            model.put("success", "false");
        }
        return model;
    }

    @RequestMapping(value = "/islogin", method = RequestMethod.GET)
    public Map<String, Object> isLogin(HttpSession session){
        Map<String, Object> model = new HashMap<>();
        if(session.getAttribute(userSessionName) == null){
            model.put("success", "true");
        }else{
            model.put("success", "false");
        }
        return model;
    }

    /**
     * 登录接口
     * @return
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public Map<String, Object> regist(String username, String password, String email, String handimage, String nickName
 ,String phone){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setCreateTime(new Date());
        userInfo.setEmail(email);
        userInfo.setHandImage(handimage);
        userInfo.setLevelId(0);
        userInfo.setNickname(nickName);
        userInfo.setPhone(phone);
        userInfo.setStoreId(0L);
        userInfo.setUpdateTime(new Date());
        userInfo.setUserIntegral(0);
        userInfo.setVerifyMobile((byte)0);
        userInfoService.addUser(userInfo);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("success", "true");
        return model;
    }


}
