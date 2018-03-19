package com.xx.shop.controller;


import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.entity.UserInfo;
import com.xx.shop.service.MailService;
import com.xx.shop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 用于的sessionkey
     */
    private final static String userSessionName = "userinfo";
    /**
     * 邮箱认证地址
     */
    private final static String mailAddress = "http://127.0.0.1:8082/user/verify";
    /**
     * 允许的验证时间
     */
    private final static long verifyOverTime = 10;

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private MailService mailService;

    /**
     * 用于登录接口
     * @param session
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultMap login(HttpSession session, String username, String password){
        if(userInfoService.isSureUser(username, password) == true){
            session.setAttribute(userSessionName,username);
            return getReturnMap(true, "", null);
        }else{
            return getReturnMap(false, "", null);
        }
    }

    /**
     * 用户查询登录接口
     * @param session
     * @return
     */
    @RequestMapping(value = "/islogin", method = RequestMethod.GET)
    public ResultMap isLogin(HttpSession session){
        if(session.getAttribute(userSessionName) == null){
            return getReturnMap(true, "", null);
        }else{
            return getReturnMap(false, "", null);
        }
    }

    /**
     * 登录接口
     * @return
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ResultMap regist(String username, String password, String email, String handimage, String nickName
 ,String phone){
        UserInfo otherinfo = userInfoService.getUserByUserName(username);
        if(otherinfo == null){
            return getReturnMap(false, "用户名已经存在", null);
        }
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
        return getReturnMap(true, "", null);
    }

    @RequestMapping(value="/sendmail", method = RequestMethod.POST)
    public ResultMap sendMail(HttpSession session, String username){
        String usn = null;
        usn = (String) session.getAttribute(userSessionName);
        usn = usn == null ? username : usn;
        if(usn.equals("")){
            return getReturnMap(false, "", null);
        }else{
            UserInfo userInfo = userInfoService.getUserByUserName(username);
            mailService.send(userInfo.getEmail(),"注册认证邮箱", mailAddress + "?username=" +username);
            session.setAttribute("time", new Date());
            return getReturnMap(true, "", null);
        }
    }

    @RequestMapping(value="/sendmailtest", method = RequestMethod.GET)
    public ResultMap vendMailTest(String email){
        mailService.send(email, "测试邮件", "收到内容了吗");
        return getReturnMap(true, "", null);
    }
    /**
     * 邮箱验证
     * @param username
     * @return
     */
    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public ResultMap verifyMail(HttpSession session, String username) throws ParseException {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = (String)session.getAttribute("time");
        if(time == null || time.equals("")){
            return getReturnMap(false, "激活超时", null);
        }
        Date fornt = sdf.parse(time);
        long sec = now.getTime() - fornt.getTime();
        long min = sec / (1000 * 60);
        if(min > verifyOverTime){
            return getReturnMap(false, "激活超时", null);
        }else{
            userInfoService.sureVerify(username, true);
            return getReturnMap(true, "激活成功", null);
        }
    }

    /**
     * 获取用户信息接口
     * @param session
     * @param username
     * @return
     */
    @RequestMapping(value = "/getuserinfo", method = RequestMethod.POST)
    public ResultMap getUserInfo(HttpSession session, String username){
        UserInfo userInfo = userInfoService.getUserByUserName(username);
        userInfo.setPassword("*********");
        return getReturnMap(true, "", userInfo);
    }



    /**
     * 获取一个用于返回的规范格式
     * @param stuta
     * @param msg
     * @param data
     * @return
     */
    private ResultMap getReturnMap(boolean stuta, String msg, Object data){
        return ResultMap.getResultMap(stuta, msg, data);
    }
}
