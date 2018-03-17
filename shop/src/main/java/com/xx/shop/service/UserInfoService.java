package com.xx.shop.service;

import com.xx.shop.entity.UserInfo;
import org.apache.catalina.User;

public interface UserInfoService {

    /**
     * 添加一个用户
     * @param user
     */
    int addUser(UserInfo user);

    /**
     * 验证用户登录
     * @param username
     * @param password
     * @return
     */
    boolean isSureUser(String username, String password);

    /**
     * 修改用户信息
     * @param username
     * @param email
     * @param handimage
     * @param nickName
     * @param phone
     */
    void modity(String username, String email, String handimage, String nickName, String phone);

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    UserInfo getUserByUserName(String username);

    /**
     * 给用户添加积分
     * @param username
     * @param point
     */
    void addPoint(String username, int point);

    /**
     * 设置用户是否验证通过
     * @param username
     * @param isVerify
     */
    void sureVerify(String username, boolean isVerify);

    /**
     * 更新用户密码
     * @param username
     * @param newpassword
     */
    void modifyPassword(String username, String newpassword);
}
