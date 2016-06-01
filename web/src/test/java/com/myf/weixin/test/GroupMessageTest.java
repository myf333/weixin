package com.myf.weixin.test;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.groupmsg.GroupMessageRet;
import com.myf.weixin.entity.weixin.groupmsg.GroupMessageStatus;
import com.myf.weixin.entity.weixin.groupmsg.GroupMessageType;
import com.myf.weixin.service.weixin.AccessTokenService;
import com.myf.weixin.service.weixin.GroupMessageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myf on 2016/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class GroupMessageTest {
    @Autowired
    private AccessTokenService tokenService;

    final Logger logger  =  LoggerFactory.getLogger(getClass());

    @Test
    public void testPreview() throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        GroupMessageRet ret = GroupMessageService.preview(accessToken,"o-SzhjpT1RWYi170nd9LwKXHj7-o",null,GroupMessageType.text,"你好呀，这是一个群发测试2");
        Assert.assertNotNull(ret);
    }

    @Test
    public void testSendByOpenId()throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        List<String> list = new ArrayList<String>();
        list.add("o-SzhjpT1RWYi170nd9LwKXHj7-o");
        list.add("o-Szhjr0s1R1iDkJJeXj7CnM8Zlk");
        String mediaId = "LyWpygZCpIcEYEu1NXlg9FIHzmmgVKLocmjn2feToPdCGSLj2JiG05oTYMS9rJpK";//必须为有效的媒体id，不然会报system error
        GroupMessageRet ret = GroupMessageService.sendGroupMessageByOpenId(accessToken,list, GroupMessageType.image,mediaId);
        Gson gson = new Gson();
        logger.info(gson.toJson(ret));
        Assert.assertNotNull(ret);
    }

    @Test
    public void testSendStatus() throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        GroupMessageStatus res = GroupMessageService.getSendStatus(accessToken,2555967676L);
        Assert.assertNotNull(res);
    }
}
