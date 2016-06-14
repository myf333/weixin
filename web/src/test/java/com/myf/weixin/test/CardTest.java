package com.myf.weixin.test;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.card.create.*;
import com.myf.weixin.entity.weixin.card.use.*;
import com.myf.weixin.entity.weixin.qrcode.QrCodeRet;
import com.myf.weixin.service.weixin.AccessTokenService;
import com.myf.weixin.service.weixin.CardService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by myf on 2016/6/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class CardTest {
    @Autowired
    private AccessTokenService tokenService;

    final Logger logger = LoggerFactory.getLogger(getClass());
    private final String appId = "wxc3063aee2db008c0";
    private final String appSecret="b4b58f2cdecc3037ac56704796275a37";

    @Test
    public void testCreate()throws Exception{
        CardBaseInfo baseInfo = new CardBaseInfo();
        baseInfo.setLogo_url("http://mmbiz.qpic.cn/mmbiz/iaL1LJM1mF9aRKPZJkmG8xXhiaHqkKSVMMWeN3hLut7X7hicFNjakmxibMLGWpXrEXB33367o7zHN0CwngnQY7zb7g/0");//卡券的商户logo，建议像素为300*300
        baseInfo.setBrand_name("BrandName");//商户名
        baseInfo.setTitle("title");//卡券名
        baseInfo.setSub_title("subtitle");//券名
        baseInfo.setColor(CardColorType.Color010);
        baseInfo.setNotice("请出示二维码");//卡券使用提醒
        baseInfo.setDescription("不能与其他优惠券一起使用");//卡券使用说明
        baseInfo.setSku(new CardSku(5000));
        Calendar calendar = Calendar.getInstance();
        long begin = calendar.getTime().getTime()/1000;
        calendar.add(Calendar.MONTH,1);
        long end = calendar.getTimeInMillis();
        baseInfo.setDate_info(new CardDateInfo(CardDateType.DATE_TYPE_FIX_TIME_RANGE,begin ,end));
        baseInfo.setService_phone("021-60858251");
        baseInfo.setGet_limit(3);
        baseInfo.setCenter_title("顶部居中");
        baseInfo.setCenter_sub_title("顶部居中sub");
        baseInfo.setCenter_url("http://www.qq.com");
        baseInfo.setCustom_url_name("立即使用");
        baseInfo.setCustom_url_sub_title("6个汉字");
        baseInfo.setCustom_url("http://www.baidu.com");
        baseInfo.setPromotion_url_name("更多优惠");
        baseInfo.setPromotion_url_sub_title("查看更多");
        baseInfo.setPromotion_url("http://www.ifeng.com");
        baseInfo.setSource("宝库中国");
        CardAdvancedInfo advancedInfo = new CardAdvancedInfo();
        advancedInfo.setUse_condition(new CardUseCondition("开箱","博物馆",false));
        List<String> icon_list = new ArrayList<>();
        icon_list.add("http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0");
        advancedInfo.setCardAbstract(new CardAbstract("宝库优惠多多",icon_list));
        List<CardTextImage> image_list = new ArrayList<>();
        image_list.add(new CardTextImage("http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0","宝库中国"));
        image_list.add(new CardTextImage("http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0","中国宝库"));
        advancedInfo.setText_image_list(image_list);
        List<CardTimeLimit> time_list = new ArrayList<>();
        time_list.add(new CardTimeLimit(CardTimeLimitType.SUNDAY,9,20,0,59));
        time_list.add(new CardTimeLimit(CardTimeLimitType.FRIDAY));
        advancedInfo.setTime_limit(time_list);
        List<BusinessServiceType> bus_service = new ArrayList<>();
        bus_service.add(BusinessServiceType.BIZ_SERVICE_DELIVER);
        bus_service.add(BusinessServiceType.BIZ_SERVICE_FREE_PARK);
        advancedInfo.setBusiness_service(bus_service);
        CardGroupon card = new CardGroupon(baseInfo,advancedInfo,"以下锅底2选1（有菌王锅、麻辣锅、大骨锅、番茄锅、清补 凉锅、酸菜鱼锅可选）：\\n大锅1份 12元\\n小锅2份 16元 ");

        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        CardCreateRet ret = CardService.createCard(accessToken,CardType.GROUPON,card);
        Gson gson = new Gson();
        logger.info(gson.toJson(ret));
        Assert.assertNotNull(ret);
    }

    @Test
    public void testCreateQrcode()throws Exception{
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        List<CardQrcodeInfo> list = new ArrayList<>();
        CardQrcodeInfo qrcodeInfo = new CardQrcodeInfo("p-SzhjmRnuVla20AKuC4sfliL1IA",null);
        qrcodeInfo.setOuter_id(1234567);
        qrcodeInfo.setOuter_str("test123");
        list.add(qrcodeInfo);
        QrCodeRet ret = CardService.createQrcode(accessToken,null, CardQrcodeType.QR_CARD,list);
        Gson gson = new Gson();
        logger.info(gson.toJson(ret));
        Assert.assertNotNull(ret);
    }

    @Test
    public void testCreateLandingPage()throws Exception{
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        CardLandingRequest request = new CardLandingRequest();
        request.setBanner("http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0");
        request.setCan_share(true);
        request.setPage_title("宝库大优惠");
        request.setScene(CardSceneType.SCENE_H5);
        List<CardLandingItem> list = new ArrayList<>();
        list.add(new CardLandingItem("p-SzhjmRnuVla20AKuC4sfliL1IA","http://mmbiz.qpic.cn/mmbiz/iaL1LJM1mF9aRKPZJkmG8xXhiaHqkKSVMMWeN3hLut7X7hicFNjakmxibMLGWpXrEXB33367o7zHN0CwngnQY7zb7g/0"));
        request.setCard_list(list);
        CardLandingPageRet ret = CardService.createLandingPage(accessToken,request);
        Gson gson = new Gson();
        logger.info(gson.toJson(ret));
        Assert.assertNotNull(ret);
    }
}
