package com.xx.shop.service.Impl;

import com.xx.shop.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/3/1 16:00.
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    /**
     * 固定的key
     */
    private static String KEY = "DDDDD";


    @Override
    public String getRedisKey() {
        return KEY;
    }

    @Override
    public String getRandomKey() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void put(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value, -1);
    }

    @Override
    public void put(String key, String value, long time) {
        stringRedisTemplate.opsForValue().set(key, value, time);
    }

    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public List<Object> getAll() {
        return null;
    }

    @Override
    public Set<String> getKeys() {
        return null;
    }

    @Override
    public boolean isKeyExists(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void empty() {

    }
}