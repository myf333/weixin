package com.myf.weixin.test;

import com.myf.weixin.entity.weixin.groupmsg.GroupMessageRet;
import com.myf.weixin.service.weixin.AccessTokenService;
import com.myf.weixin.service.weixin.GroupMessageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by myf on 2016/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class GroupMessageTest {
    @Autowired
    private AccessTokenService tokenService;

    @Test
    public void testPreview() throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        GroupMessageRet ret = GroupMessageService.preview(accessToken,"o-SzhjpT1RWYi170nd9LwKXHj7-o",null,"你好呀，这是一个群发测试");
        Assert.assertNotNull(ret);
    }
}
