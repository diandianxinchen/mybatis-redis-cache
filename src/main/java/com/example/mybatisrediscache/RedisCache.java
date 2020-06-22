package com.example.mybatisrediscache;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache implements Cache {
    private String id;
    private RedisTemplate redisTemplate = ApplicationContextHolder.getRedisTemplate();
    private final static int EXPIRE_TIME_IN_MINUTES = 10 * 60 * 1000;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public RedisCache(String id){
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        System.out.println("put key = " + key + " , value = " + value);
        redisTemplate.opsForValue().set(key,value,EXPIRE_TIME_IN_MINUTES, TimeUnit.SECONDS);
    }

    @Override
    public Object getObject(Object key) {
        System.out.println("get key = " + key);
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Object removeObject(Object key) {
        System.out.println("remove key = " + key);
        return redisTemplate.delete(key);
    }

    @Override
    public void clear() {
        redisTemplate.execute((RedisCallback) connection -> {
            connection.flushDb();
            return null;
        });
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
