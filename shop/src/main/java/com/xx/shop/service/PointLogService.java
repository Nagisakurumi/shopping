package com.xx.shop.service;

import com.xx.shop.entity.PointLog;

import java.util.Date;
import java.util.List;

public interface PointLogService {

    /**
     * 添加一条积分记录
     * @param userid
     * @param point
     */
    void addPointLog(long userid, int point);

    /**
     * 根据时间查询
     * @param now
     * @param isbig
     * @param isup
     * @return
     */
    List<PointLog> queryLogByTime(Date now, boolean isbig, boolean isup);

    /**
     * 根据用户id查询
     * @param userid
     * @param isup
     * @return
     */
    List<PointLog> queryLogByUserid(long userid, boolean isup);

    /**
     * 查询介于2个时间之间的
     * @param timeone
     * @param timetwo
     * @param isup
     * @return
     */
    List<PointLog> queryLogBetweenTime(Date timeone, Date timetwo, boolean isup);

    /**
     * 根据用户名获取日志
     * @param name
     * @param isup
     * @return
     */
    List<PointLog> queryLogByUserName(String name, boolean isup);


}
