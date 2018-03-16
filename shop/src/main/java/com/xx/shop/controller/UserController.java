package com.xx.shop.controller;


import com.xx.shop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> Login(HttpSession session, String username, String password){
        Map<String, Object> model = new HashMap<>();
        if(username == "1" && password == "1"){
            model.put("success", "true");
            session.setAttribute(userSessionName,username);
        }else{
            model.put("success", "false");
        }
        return model;
    }

    @RequestMapping(value = "/islogin", method = RequestMethod.GET)
    public Map<String, Object> IsLogin(HttpSession session){
        Map<String, Object> model = new HashMap<>();
        if(session.getAttribute(userSessionName) == null){
            model.put("success", "true");
        }else{
            model.put("success", "false");
        }
        return model;
    }

}
