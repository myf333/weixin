package com.myf.weixin.test;

import com.myf.weixin.entity.weixin.WxJsonResult;
import com.myf.weixin.entity.weixin.customservice.*;
import com.myf.weixin.service.weixin.AccessTokenService;
import com.myf.weixin.service.weixin.CustomerService;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by myf on 2016/6/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class CusMsgTest {
    @Autowired
    private AccessTokenService tokenService;

    final Logger logger  =  LoggerFactory.getLogger(getClass());

    private final String appId = "wxc3063aee2db008c0";
    private final String appSecret="b4b58f2cdecc3037ac56704796275a37";

    @Test
    public void testSendCusMessage()throws Exception{
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        String openId = "o-SzhjpT1RWYi170nd9LwKXHj7-o";
        CusMsgText text = new CusMsgText();
        text.setTouser(openId);
        text.setMsgtype(CusMsgType.text);
        text.setText(new TextContentItem("你好呀，请问有什么需要吗?"));
        WxJsonResult ret = CustomerService.sendCusMessage(accessToken,text);
        Assert.assertEquals(0, ret.getErrcode());

        CusMsgNews news = new CusMsgNews();
        news.setTouser(openId);
        news.setMsgtype(CusMsgType.news);
        List<ArticleItem> list = new ArrayList<>();
        list.add(new ArticleItem("你好1","这是一条客服消息1","http://www.qq.com","http://image.ltchina.com/OriginalPicture/20160506/a16eb8db-8aa8-4d6e-9894-49d83c97d061.jpg"));
        list.add(new ArticleItem("你好2","这是一条客服消息2","http://www.baidu.com","http://image.ltchina.com/OriginalPicture/20160506/a16eb8db-8aa8-4d6e-9894-49d83c97d061.jpg"));
        list.add(new ArticleItem("你好3","这是一条客服消息3","http://www.taobao.com","http://image.ltchina.com/OriginalPicture/20160506/a16eb8db-8aa8-4d6e-9894-49d83c97d061.jpg"));
        list.add(new ArticleItem("你好4","这是一条客服消息4","http://www.tmall.com","http://image.ltchina.com/OriginalPicture/20160506/a16eb8db-8aa8-4d6e-9894-49d83c97d061.jpg"));
        news.setNews(new ArticleListItem(list));
        ret = CustomerService.sendCusMessage(accessToken,news);
        Assert.assertEquals(0, ret.getErrcode());
    }

    @Test
    public void testAddKf()throws Exception{
        String url = MessageFormat.format("http://dz.weixin.ltchanpin.cn/Home/gettoken?appid={0}&appsecret={1}",appId,appSecret);
        String accessToken = HttpUtil.Get(url,null);
        Assert.assertNotNull(accessToken);
        Assert.assertNotEquals("",accessToken);

        String weiXinCode = "ltjsfw";
        KFAccount account = new KFAccount();
        account.setKf_account("myf@"+weiXinCode);
        account.setNickname("毛哥");
        WxJsonResult ret = CustomerService.addKFAccount(accessToken,account);
        Assert.assertEquals(0,ret.getErrcode());

    }

    @Test
    public void testInviteKf()throws Exception{
        String url = MessageFormat.format("http://dz.weixin.ltchanpin.cn/Home/gettoken?appid={0}&appsecret={1}",appId,appSecret);
        String accessToken = HttpUtil.Get(url,null);
        Assert.assertNotNull(accessToken);
        Assert.assertNotEquals("",accessToken);

        String weiXinCode = "ltjsfw";
        String account = "myf@"+weiXinCode;
        WxJsonResult ret = CustomerService.inviteWorker(accessToken, account,"myf_feng");
        Assert.assertEquals(0,ret.getErrcode());
    }

    @Test
    public void testKfList()throws Exception{
        String url = MessageFormat.format("http://dz.weixin.ltchanpin.cn/Home/gettoken?appid={0}&appsecret={1}",appId,appSecret);
        String accessToken = HttpUtil.Get(url,null);
        Assert.assertNotNull(accessToken);
        Assert.assertNotEquals("",accessToken);

        KFListRet ret = CustomerService.getKFList(accessToken);
        Assert.assertNotNull(ret);
    }

    @Test
    public void testKfOnLineList()throws Exception{
        String url = MessageFormat.format("http://dz.weixin.ltchanpin.cn/Home/gettoken?appid={0}&appsecret={1}",appId,appSecret);
        String accessToken = HttpUtil.Get(url,null);
        Assert.assertNotNull(accessToken);
        Assert.assertNotEquals("",accessToken);

        KFOnlineRet ret = CustomerService.getKFOnlineList(accessToken);
        Assert.assertNotNull(ret);
    }

    @Test
    public void testUpdateKf()throws Exception{
        String url = MessageFormat.format("http://dz.weixin.ltchanpin.cn/Home/gettoken?appid={0}&appsecret={1}",appId,appSecret);
        String accessToken = HttpUtil.Get(url,null);
        Assert.assertNotNull(accessToken);
        Assert.assertNotEquals("",accessToken);

        String weiXinCode = "ltjsfw";
        KFAccount account = new KFAccount();
        account.setKf_account("myf@"+weiXinCode);
        account.setNickname("毛哥毛哥");

        WxJsonResult ret = CustomerService.updateKFAccount(accessToken,account);
        Assert.assertNotNull(ret);
    }

    @Test
    public void testKfHeadImg()throws Exception{
        String url = MessageFormat.format("http://dz.weixin.ltchanpin.cn/Home/gettoken?appid={0}&appsecret={1}",appId,appSecret);
        String accessToken = HttpUtil.Get(url,null);
        Assert.assertNotNull(accessToken);
        Assert.assertNotEquals("",accessToken);

        WxJsonResult ret = CustomerService.uploadHeadImg(accessToken,"myf@ltjsfw","600x600.jpg","d:\\600x600.jpg");
        Assert.assertNotNull(ret);
    }

    @Test
    public void testDelKf()throws Exception{
        String url = MessageFormat.format("http://dz.weixin.ltchanpin.cn/Home/gettoken?appid={0}&appsecret={1}",appId,appSecret);
        String accessToken = HttpUtil.Get(url,null);
        Assert.assertNotNull(accessToken);
        Assert.assertNotEquals("",accessToken);

        WxJsonResult ret = CustomerService.delKFAccount(accessToken,"myf@ltjsfw");
        Assert.assertNotNull(ret);
    }
}
