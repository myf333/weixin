package com.myf.weixin.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by myf on 2016/5/9.
 */
@Service("RedisUtil")
public class RedisUtil {
    @Autowired
    private RedisTemplate<String,String> redis;

    /**
     *设置过期键值,时间单位为秒
     */
    public void SetKey(String key, String value, long expires){
        ValueOperations<String,String> values = redis.opsForValue();
        values.set(key,value,expires, TimeUnit.SECONDS);
    }
    /**
     *设置不过期键值
     */
    public void SetKey(String key, String value){
        ValueOperations<String,String> values = redis.opsForValue();
        values.set(key,value);
    }

    /**
     *获取键值
     */
    public String GetKey(String key){
        ValueOperations<String,String> values = redis.opsForValue();
        return values.get(key);
    }

    /**
     *原子计数
     */
    public long GetInc(String key,long step){
        ValueOperations<String,String> values = redis.opsForValue();
        return values.increment(key,step);
    }

    /**
     *删除键值
     */
    public void DeleteKey(String key){
        redis.delete(key);
    }
}
