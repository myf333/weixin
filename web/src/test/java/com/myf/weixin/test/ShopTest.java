package com.myf.weixin.test;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.shop.CategoryListRet;
import com.myf.weixin.entity.weixin.shop.ShopInfoRet;
import com.myf.weixin.entity.weixin.shop.ShopListRet;
import com.myf.weixin.service.weixin.AccessTokenService;
import com.myf.weixin.service.weixin.ShopService;
import com.myf.weixin.util.HttpUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.MessageFormat;

/**
 * Created by myf on 2016/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class ShopTest {
    @Autowired
    private AccessTokenService tokenService;

    final Logger logger  =  LoggerFactory.getLogger(getClass());

    private final String appId = "wxc3063aee2db008c0";
    private final String appSecret="b4b58f2cdecc3037ac56704796275a37";

    @Test
    public void testGetCategory()throws Exception{
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        CategoryListRet ret = ShopService.getWxCategory(accessToken);
        Assert.assertNotNull(ret);
        Gson gson = new Gson();
        logger.info(gson.toJson(ret));
    }

    @Test
    public void testGetShopList()throws Exception{
        String accessToken = tokenService.GetAccessToken(appId, appSecret);
        ShopListRet ret = ShopService.getPoiList(accessToken,0,10);
        Assert.assertNotNull(ret);
    }

    @Test
    public void testGetShopInfo()throws Exception{
        String accessToken = tokenService.GetAccessToken(appId, appSecret);
        ShopListRet ret = ShopService.getPoiList(accessToken,0,10);
        Assert.assertNotNull(ret);
        String poiId = ret.getBusiness_list().get(0).getBase_info().getPoi_id();
        ShopInfoRet sRet = ShopService.getPoi(accessToken,poiId);
        Assert.assertNotNull(sRet);
    }
}
