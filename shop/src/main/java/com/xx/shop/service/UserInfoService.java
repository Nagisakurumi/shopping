package com.xx.shop.service;

import com.xx.shop.entity.UserInfo;
import org.apache.catalina.User;

public interface UserInfoService {

    /**
     * 添加一个用户
     * @param user
     */
    int addUser(UserInfo user);
}
