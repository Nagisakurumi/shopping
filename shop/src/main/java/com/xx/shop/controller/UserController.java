package com.xx.shop.controller;


import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.common.SessionHelper;
import com.xx.shop.dto.SessionUser;
import com.xx.shop.entity.UserInfo;
import com.xx.shop.service.MailService;
import com.xx.shop.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

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
    @ApiOperation(nickname = "swagger-login", value = "Swagger的世界", notes = "测试HelloWorld")
    public ResultMap login(HttpSession session, @ApiParam(value = "用户名") String username,@ApiParam(value = "密码") String password){
        SessionUser sessionUser = userInfoService.isSureUser(username, password);
        if(sessionUser!=null){
            session.setAttribute(SessionHelper.userInfo,sessionUser);
            return ResultMap.getResultMap(null);
        }else{

            return ResultMap.getErrorResultMap("登录失败");
        }
    }

    /**
     * 用户查询登录接口
     * @param session
     * @return
     */
    @RequestMapping(value = "/islogin", method = RequestMethod.GET)
    public ResultMap isLogin(HttpSession session){
        if(session.getAttribute(SessionHelper.userInfo) == null){
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
        userInfo.setStoreId(-1L);
        userInfo.setUpdateTime(new Date());
        userInfo.setUserIntegral(0);
        userInfo.setVerifyMobile((byte)0);
        userInfoService.addUser(userInfo);
        return getReturnMap(true, "", null);
    }

    /**
     * 发送邮件接口
     * @param session
     * @param username
     * @return
     */
    @RequestMapping(value="/sendmail", method = RequestMethod.POST)
    public ResultMap sendMail(HttpSession session, String username){
        String usn = null;
        usn = (String) session.getAttribute(SessionHelper.userInfo);
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
     * 修改用户头像接口
     * @param file
     * @param userid
     * @return
     */
    @RequestMapping(value = "/updatehandimage", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultMap modifyHandImage(@RequestParam("file")MultipartFile file, @RequestParam("userid")long userid){
        if(!file.isEmpty()){
            if(file.getContentType().contains("image")){
                return userInfoService.modifyHandImage(file, userid);
            }else{
                return ResultMap.getResultMap(false, "不是图片类型", null);
            }
        }else{
            return ResultMap.getResultMap(false, "文件不能为空", null);
        }
    }

    /**
     * 修改用户密码接口
      * @param username
     * @param oldpassword
     * @param newpassword
     * @return
     */
    @RequestMapping(value = "/modifypassword", method = RequestMethod.POST)
    public ResultMap modifyUserPassword(String username, String oldpassword, String newpassword){
       if(!userInfoService.checkUserInfo(username, oldpassword)) {
           return ResultMap.getResultMap(false, "用户名或者旧密码不正确", null);
       }else{
           userInfoService.modifyPassword(username, newpassword);
           return ResultMap.getResultMap(true, "修改成功", null);
       }
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
