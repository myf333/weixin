package com.myf.weixin.test;

import com.myf.weixin.util.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by myf on 2016/5/9.
 * spring-data-redis 对 key 和 value 都进行了序列化 变成byte[]
 * 再调用对应的redis java client进行存储的。
 * 那应该就是通过spring-data-redis进入redis的key变了,redis-cli直接通过key取值会为 nil
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class RedisTest {
    @Autowired
    private RedisUtil redis;

    @Test
    public void testSetAndGet(){
        String key = "com.myf.upload.get.set";
        redis.SetKey(key,"myf");
        String res = redis.GetKey(key);
        Assert.assertEquals(res, "myf");
    }
}
