package com.myf.weixin.test;

import com.myf.weixin.util.RabbitUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by myf on 2016/5/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class RabbitTest {
    @Autowired
    private RabbitUtil rabbit;

    @Test
    public void testSend(){
        rabbit.sendData("testQueue","hahaha");
    }

    @Test
    public void testReceive(){
        String res = rabbit.receiveData("testQueue");
        if(res!=null){
            Assert.assertEquals("hahaha", res);
        }
    }
}
