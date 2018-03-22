package com.xx.shop.service;

import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.dto.SessionUser;
import com.xx.shop.entity.UserInfo;
import org.springframework.web.multipart.MultipartFile;

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
    SessionUser isSureUser(String username, String password);

    /**
     * 修改用户信息
     * @param username
     * @param email
     * @param nickName
     * @param phone
     */
    void modity(String username, String email, String nickName, String phone);

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

    /**
     * 获取随机生成的验证码
     * @return key
     */
    String getVerifyImage();

    /**
     * 验证key所对应的value值是否正确
     * @param key
     * @param value
     * @return
     */
    boolean verifyValue(String key, String value);

    /**
     * 修改用户头像
     * @param file
     * @param userid
     * @return
     */
    ResultMap modifyHandImage(MultipartFile file, long userid);

    /**
     * 检测用户是否存在
     * @param usernamae
     * @return
     */
    boolean isExistsUser(String usernamae);

    /**
     * 检验用户信息是否正确
     * @param username
     * @param password
     * @return
     */
    boolean checkUserInfo(String username, String password);

    /**
     * 根据id获取用户信息
     * @param userid
     * @return
     */
    UserInfo getUserInfoById(long userid);

    /**
     * 设置用户的店铺
     * @param userid
     * @param storeid -1 表示没有店铺
     * @return
     */
    boolean setUserStore(long userid, long storeid);
}
