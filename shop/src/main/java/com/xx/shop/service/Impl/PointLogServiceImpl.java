package com.xx.shop.service.Impl;

import com.xx.shop.dao.PointLogMapper;
import com.xx.shop.dao.UserInfoMapper;
import com.xx.shop.entity.PointLog;
import com.xx.shop.entity.PointLogExample;
import com.xx.shop.entity.UserInfo;
import com.xx.shop.service.PointLogService;
import com.xx.shop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PointLogServiceImpl implements PointLogService {

    @Autowired
    private PointLogMapper pointLogMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Override
    public void addPointLog(long userid, int point) {
        PointLog pointLog = new PointLog();
        pointLog.setUserId(userid);
        pointLog.setPoint(point);
        pointLog.setCreateTime(new Date());
        pointLogMapper.insert(pointLog);
    }

    @Override
    public List<PointLog> queryLogByTime(Date now, boolean isbig, boolean isup) {
        PointLogExample pointLogExample = new PointLogExample();
        PointLogExample.Criteria criteria = pointLogExample.createCriteria();
        if(isbig)
            criteria.andCreateTimeGreaterThan(now);
        else
            criteria.andCreateTimeLessThan(now);
        pointLogExample.setOrderByClause("create_time " + (isup ? "ASC" : "desc") );
        return pointLogMapper.selectByExample(pointLogExample);
    }

    @Override
    public List<PointLog> queryLogByUserid(long userid, boolean isup) {
        PointLogExample pointLogExample = new PointLogExample();
        pointLogExample.setOrderByClause("create_time " + (isup ? "ASC" : "desc"));
        PointLogExample.Criteria criteria = pointLogExample.createCriteria();
        criteria.andUserIdEqualTo(userid);
        return pointLogMapper.selectByExample(pointLogExample);
    }

    @Override
    public List<PointLog> queryLogBetweenTime(Date timeone, Date timetwo, boolean isup) {
        PointLogExample pointLogExample = new PointLogExample();
        PointLogExample.Criteria criteria = pointLogExample.createCriteria();
        criteria.andCreateTimeBetween(timeone, timetwo);
        pointLogExample.setOrderByClause("create_time " + (isup ? "ASC" : "desc") );
        return pointLogMapper.selectByExample(pointLogExample);
    }

    @Override
    public List<PointLog> queryLogByUserName(String name, boolean isup) {
        long userid = userInfoService.getUserByUserName(name).getUserId();
        return queryLogByUserid(userid, isup);
    }
}
