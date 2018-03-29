package com.xx.shop.service.Impl;

import com.xx.shop.MyConfigs.WebConfig;
import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.dao.UserInfoMapper;
import com.xx.shop.dto.SessionUser;
import com.xx.shop.entity.UserInfo;
import com.xx.shop.entity.UserInfoExample;
import com.xx.shop.service.MailService;
import com.xx.shop.service.UserInfoService;
import com.xx.shop.toolspage.Encryp.MD5;
import com.xx.shop.toolspage.StringUt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class UserInfoServiceImpl  implements UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private MailService mailService;
    @Autowired
   private WebConfig webConfig;

    @Override
    public int addUser(UserInfo user) {
        user.setPassword(StringUt.md5Password(user.getPassword()));
        return userInfoMapper.insert(user);
    }


    @Override
    public SessionUser isSureUser(String username, String password) {
        UserInfo userInfo = getUserByUserName(username);
        if(StringUt.md5Password(password).equals(userInfo.getPassword())){
            SessionUser sessionUser = new SessionUser();
            sessionUser.setUserId(userInfo.getUserId());
            sessionUser.setUsername(username);
            return sessionUser;
        }else{
            return null;
        }
    }

    @Override
    public void modity(String username, String email, String nickName, String phone) {
        UserInfo userInfo = getUserByUserName(username);
        userInfo.setEmail(email);
        userInfo.setNickname(nickName);
        userInfo.setPhone(phone);
        userInfo.setUpdateTime(new Date());
        userInfoMapper.updateByPrimaryKey(userInfo);
    }
    @Override
    public UserInfo getUserByUserName(String username){
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<UserInfo> userList = userInfoMapper.selectByExample(userInfoExample);
        if(userList.size() == 0)
            return null;
        return userList.get(0);
    }
    @Override
    public void addPoint(String username, int point){
        UserInfo userInfo = getUserByUserName(username);
        userInfo.setUserIntegral(userInfo.getUserIntegral() + point);
        userInfoMapper.updateByPrimaryKey(userInfo);
    }
    @Override
    public void sureVerify(String username, boolean isVerify){
        UserInfo userInfo = getUserByUserName(username);
        userInfo.setVerifyMobile(isVerify == true ? (byte)1 : (byte)0);

        userInfoMapper.updateByPrimaryKey(userInfo);
    }
    @Override
    public void modifyPassword(String username, String newpassword){
        UserInfo userInfo = getUserByUserName(username);
        userInfo.setPassword(newpassword);
        mailService.send(userInfo.getEmail(), "密码被修改", "您的密码已经于：" + (new Date().toString())
        + " 被修改， 请确认是否是本人修改，如果不是本人修改的请及时联系客服");
        userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public String getVerifyImage() {
        return null;
    }

    @Override
    public boolean verifyValue(String key, String value) {
        return false;
    }

    @Override
    public ResultMap modifyHandImage(MultipartFile file, long userid) {
        try{
            String newfilename = File.separator + "userhandimages" + File.separator + userid + "_handimage." +
                    StringUt.getExtensionName((file.getOriginalFilename()));
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userid);
            File oldfile = new File(webConfig.getUploadpath().concat(userInfo.getHandImage()));
            newfilename = webConfig.getUploadpath().concat(newfilename);
            File newfile = new File(newfilename);
            if(oldfile.exists()){
                oldfile.delete();
            }
            oldfile = null;
            userInfo.setHandImage(newfilename);
            userInfoMapper.updateByPrimaryKey(userInfo);
            file.transferTo(newfile);
            file = null;
            newfile = null;
            return ResultMap.getResultMap(true, "上传成功", null);
        }catch (Exception e){
            return ResultMap.getResultMap(false, "服务器异常", null);
        }
    }

    @Override
    public boolean isExistsUser(String usernamae) {
        if(getUserByUserName(usernamae) == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean checkUserInfo(String username, String password) {
        UserInfo userInfo = getUserByUserName(username);
        if(userInfo == null){
            return false;
        }
        if(!userInfo.getPassword().equals(password)){
            return false;
        }
        return  true;
    }

    @Override
    public UserInfo getUserInfoById(long userid) {
        return userInfoMapper.selectByPrimaryKey(userid);
    }

    @Override
    public boolean setUserStore(long userid, long storeid) {
        UserInfo userInfo = getUserInfoById(userid);
        if(userInfo == null){
            return false;
        }else{
            userInfo.setStoreId(storeid);
            if(userInfoMapper.updateByPrimaryKey(userInfo) == 1){
                return true;
            }else{
                return false;
            }
        }
    }
}
