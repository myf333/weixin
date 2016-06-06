package com.myf.weixin.test;

import com.myf.weixin.entity.weixin.template.*;
import com.myf.weixin.service.weixin.AccessTokenService;
import com.myf.weixin.service.weixin.TemplateService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by myf on 2016/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class TemplateTest {
    @Autowired
    private AccessTokenService tokenService;

    final Logger logger  =  LoggerFactory.getLogger(getClass());

    @Test
    public void testGetIndustry()throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        IndustryRet ret = TemplateService.getIndustry(accessToken);
        Assert.assertNotNull(ret);
    }

    @Test
    public void testGetTemplateList()throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        TemplateListRet ret = TemplateService.getAllTemplate(accessToken);
        Assert.assertNotNull(ret);
    }

    @Test
    public void testSendTemplateMessage()throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        SendTemplateMsgRequest<TemplateData> request = new SendTemplateMsgRequest<>();
        TemplateData data = new TemplateData();
        data.setFirst(new TemplateItem("您的订单意见支付成功","#173177"));
        data.setOrderMoneySum(new TemplateItem("100元","#173177"));
        data.setOrderProductName(new TemplateItem("技术服务费用","#173177"));
        data.setRemark(new TemplateItem("我们会第一时间与您取得联系","#173177"));
        request.setData(data);
        request.setTemplate_id("CqfIJJYCfTEp7a9XLkvnABTJgF8igII86cyimYL7Js0");
        request.setTopcolor("#FF0000");
        request.setTouser("o-SzhjpT1RWYi170nd9LwKXHj7-o");
        request.setUrl("http://www.baidu.com");

        SendTemplateRet ret = TemplateService.sendTemplateMessage(accessToken,request);
        Assert.assertNotNull(ret);
    }

}

class TemplateData{
    private TemplateItem first;
    private TemplateItem orderMoneySum;
    private TemplateItem orderProductName;
    private TemplateItem Remark;

    public TemplateItem getFirst() {
        return first;
    }

    public void setFirst(TemplateItem first) {
        this.first = first;
    }

    public TemplateItem getOrderMoneySum() {
        return orderMoneySum;
    }

    public void setOrderMoneySum(TemplateItem orderMoneySum) {
        this.orderMoneySum = orderMoneySum;
    }

    public TemplateItem getOrderProductName() {
        return orderProductName;
    }

    public void setOrderProductName(TemplateItem orderProductName) {
        this.orderProductName = orderProductName;
    }

    public TemplateItem getRemark() {
        return Remark;
    }

    public void setRemark(TemplateItem remark) {
        Remark = remark;
    }
}
