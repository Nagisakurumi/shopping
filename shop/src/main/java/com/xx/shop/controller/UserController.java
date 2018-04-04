package com.xx.shop.controller;


import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.common.SessionHelper;
import com.xx.shop.dto.SessionUser;
import com.xx.shop.entity.UserInfo;
import com.xx.shop.service.MailService;
import com.xx.shop.service.RedisService;
import com.xx.shop.service.UserInfoService;
import com.xx.shop.toolspage.Encryp.MD5;
import com.xx.shop.toolspage.VerifyCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    @Autowired
    private RedisService redisService;
    /**
     * 用于登录接口
     * @param session
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultMap login(HttpSession session, @RequestBody UserInfo userInfo){
        if(session.getAttribute(SessionHelper.userInfo) != null)
            return ResultMap.getResultMap("登录成功");
        SessionUser sessionUser = userInfoService.isSureUser(userInfo.getUsername(), userInfo.getPassword());
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
    @ResponseBody
    public ResultMap regist(@RequestBody UserInfo userInfo){
        UserInfo otherinfo = userInfoService.getUserByUserName(userInfo.getUsername());
        if(otherinfo != null){
            return getReturnMap(false, "用户名已经存在", null);
        }
//        UserInfo userInfo = new UserInfo();
        userInfo.setHandImage("");
        userInfo.setNickname("用户" + userInfo.getUsername());
        userInfo.setCreateTime(new Date());
        userInfo.setLevelId(0);
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
    public ResultMap sendMail(HttpSession session, @RequestParam("username")String username){
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
    public ResultMap verifyMail(HttpSession session, @RequestParam("username")String username) throws ParseException {
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
    public ResultMap getUserInfo(HttpSession session, @RequestParam("username")String username){
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
    public ResultMap modifyUserPassword(@RequestParam("username")String username, @RequestParam("oldpassword")String oldpassword,
                                        @RequestParam("newpassword")String newpassword){
       if(!userInfoService.checkUserInfo(username, oldpassword)) {
           return ResultMap.getResultMap(false, "用户名或者旧密码不正确", null);
       }else{
           userInfoService.modifyPassword(username, newpassword);
           return ResultMap.getResultMap(true, "修改成功", null);
       }
    }

    /**
     * 获取验证码id
     * @return
     */
    @RequestMapping(value = "/getverid", method = RequestMethod.GET)
    public ResultMap getVerifyCodeUid(){
        String uid = redisService.getRandomKey();
        return getReturnMap(true, "生成uid", uid);
    }

    /**
     * 获取验证码接口
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/getvercode", method = RequestMethod.GET)
    public void getVerificationCode(HttpServletResponse response, String uid) throws IOException {

        ServletOutputStream stream = response.getOutputStream();
        int index = new Random().nextInt(uid.length() - 5);
        String vervalue = uid.substring(index, index + 4);
        redisService.put(uid, vervalue, 10000);
        VerifyCodeUtils.outputImage(90, 40, stream, vervalue);
        //return getReturnMap(true, "成功",  uid.trim());
    }

    /**
     * 验证验证码是否正确
     * @param value
     * @return
     */
    @RequestMapping(value = "/verifycode", method = RequestMethod.GET)
    public ResultMap getVerifyCode(String key, String value){
        if(redisService.isKeyExists(key) == false){
            return getReturnMap(false, "验证码已经过期，请从新获取", null);
        }
        if(value == redisService.get(key)){
            return getReturnMap(true, "验证通过", null);
        }else{
            return getReturnMap(false, "验证失败,错误的验证码", null);
        }
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResultMap test(){
        redisService.put("test", "value", 10000);
        return getReturnMap(true, "成功", redisService.get("test"));
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
    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method=RequestMethod.GET)
    public List<UserInfo> getUserList() {
        List<UserInfo> r = new ArrayList<UserInfo>();
        return r;
    }




}
