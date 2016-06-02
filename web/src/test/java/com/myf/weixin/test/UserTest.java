package com.myf.weixin.test;

import com.myf.weixin.entity.weixin.user.BatchUserItem;
import com.myf.weixin.entity.weixin.user.BatchUserRequest;
import com.myf.weixin.entity.weixin.user.OpenIdListRet;
import com.myf.weixin.entity.weixin.user.WxUserBatchRet;
import com.myf.weixin.service.weixin.AccessTokenService;
import com.myf.weixin.service.weixin.UserService;
import com.myf.weixin.util.HttpUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Created by myf on 2016/6/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class UserTest {
    @Autowired
    private AccessTokenService tokenService;

    @Test
    public void testBatchGetUser()throws Exception{
        BatchUserRequest request = new BatchUserRequest();
        BatchUserItem item = new BatchUserItem();
        item.setOpenid("o-SzhjpT1RWYi170nd9LwKXHj7-o");
        item.setLang("zh-CN");
        List<BatchUserItem> list = new ArrayList<>();
        list.add(item);
        BatchUserItem item2 = new BatchUserItem();
        item2.setOpenid("o-Szhjr0s1R1iDkJJeXj7CnM8Zlk");
        item2.setLang("zh-CN");
        list.add(item2);
        request.setUser_list(list);

        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);

        WxUserBatchRet res = UserService.getUserInfoBatch(accessToken,request);
        Assert.assertNotNull(res);
    }

    @Test
    public void testOpenIdList()throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        OpenIdListRet ret = UserService.getOpenIdList(accessToken,"");
        Assert.assertNotNull(ret);
    }
}
