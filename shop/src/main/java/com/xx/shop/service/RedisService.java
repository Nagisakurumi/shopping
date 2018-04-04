package com.xx.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/3/1 14:57.
 */
@Service
public interface RedisService {

    /**
     * 存入redis中的key固定的key
     *
     * @return
     */
     public String getRedisKey();

    /**
     * 获取随机的key
     * @return
     */
     public String getRandomKey();

    /**
     * 添加
     *
     * @param key    key
     * @param value 对象
     */
    public void put(String key, String value);

    /**
     * 保存
     * @param key
     * @param value
     * @param time
     */
    public void put(String key, String value, long time);
    /**
     * 删除
     *
     * @param key 传入key的名称
     */
    public void remove(String key);

    /**
     * 查询
     *
     * @param key 查询的key
     * @return
     */
    public String get(String key);

    /**
     * 获取当前redis库下所有对象
     *
     * @return
     */
    public List<Object> getAll();
    /**
     * 查询查询当前redis库下所有key
     *
     * @return
     */
    public Set<String> getKeys();

    /**
     * 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return
     */
    public boolean isKeyExists(String key);

    /**
     * 查询当前key下缓存数量
     *
     * @return
     */
    public long count();

    /**
     * 清空redis
     */
    public void empty();
}