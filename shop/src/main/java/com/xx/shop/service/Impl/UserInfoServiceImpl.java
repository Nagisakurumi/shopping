package com.xx.shop.service.Impl;

import com.xx.shop.dao.UserInfoMapper;
import com.xx.shop.entity.UserInfo;
import com.xx.shop.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl  implements UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int addUser(UserInfo user) {
        return userInfoMapper.insert(user);
    }


}
