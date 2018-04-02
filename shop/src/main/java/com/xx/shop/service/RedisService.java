package com.xx.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/3/1 14:57.
 */
public interface RedisService<T> {

    /**
     * 存入redis中的key
     *
     * @return
     */
     public String getRedisKey();

    /**
     * 添加
     *
     * @param key    key
     * @param doamin 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    public void put(String key, T doamin, long expire);

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
    public T get(String key);

    /**
     * 获取当前redis库下所有对象
     *
     * @return
     */
    public List<T> getAll();
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