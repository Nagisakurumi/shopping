package com.xx.shop.service.Impl;

import com.xx.shop.dao.UserInfoMapper;
import com.xx.shop.entity.OrderExample;
import com.xx.shop.entity.UserInfo;
import com.xx.shop.entity.UserInfoExample;
import com.xx.shop.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserInfoServiceImpl  implements UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int addUser(UserInfo user) {
        return userInfoMapper.insert(user);
    }

    @Override
    public boolean isSureUser(String username, String password) {
        UserInfo userInfo = getUserByUserName(username);
        if(userInfo == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void modity(String username, String email, String handimage, String nickName, String phone) {
        UserInfo userInfo = getUserByUserName(username);
        userInfo.setEmail(email);
        userInfo.setHandImage(handimage);
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
        userInfoMapper.updateByPrimaryKey(userInfo);
    }
}
