package com.myf.weixin.test;

import com.myf.weixin.entity.weixin.menu.MenuRet;
import com.myf.weixin.service.weixin.AccessTokenService;
import com.myf.weixin.service.weixin.MenuService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by myf on 2016/6/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class MenuTest {
    @Autowired
    private AccessTokenService tokenService;

    @Test
    public void testGetMenu()throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        MenuRet ret = MenuService.getMenu(accessToken);
        Assert.assertNotNull(ret);
    }
}
