package com.myf.weixin.test;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.groupmsg.GroupMessageRet;
import com.myf.weixin.entity.weixin.groupmsg.GroupMessageStatus;
import com.myf.weixin.entity.weixin.groupmsg.GroupMessageType;
import com.myf.weixin.entity.weixin.media.Article;
import com.myf.weixin.entity.weixin.media.MaterialNew;
import com.myf.weixin.entity.weixin.media.MediaUploadRet;
import com.myf.weixin.service.weixin.AccessTokenService;
import com.myf.weixin.service.weixin.GroupMessageService;
import com.myf.weixin.util.HttpUtil;
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

    @Test
    public void testMpNews() throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);

        MaterialNew news = new MaterialNew();
        Article article = new Article();
        article.setAuthor("莫问痴");
        article.setContent("1.嵌套循环连接(Nested Loops)适用范围\n" +
                "两个表, 一个叫外部表, 一个叫内部表.\n" +
                "\n" +
                "如果外部输入非常小，而内部输入非常大并且已预先建立索引，那么嵌套循环联接将特别有效率。\n" +
                "\n" +
                "关于连接时哪个表为outer表，哪个为inner表，sql server会自动给你安排，和你写的位置无关，它自动选择数据量小的表为outer表， 数据量大的表为inner表。\n" +
                "\n" +
                "\n" +
                "2.合并联接(Merge)\n" +
                "指两个表在on的过滤条件上都有索引, 都是有序的, 这样, join时, sql server就会使用Merge join, 这样性能更好.\n" +
                "\n" +
                "如果一个有索引,一个没索引,则会选择Nested Loops join.\n" +
                " \n" +
                "\n" +
                "3.哈希联接(Hash)\n" +
                "如果两个表在on的过滤条件上都没有索引, 则就会使用Hash join.\n" +
                "\n" +
                "也就是说, 使用Hash join算法是由于缺少现成的索引.");
        article.setContent_source_url("http://www.baidu.com");
        article.setDigest("嵌套循环连接(Nested Loops), 合并联接(Merge), 哈希联接(Hash)的适用情况");
        article.setShow_cover_pic(1);
        article.setThumb_media_id("LyWpygZCpIcEYEu1NXlg9FIHzmmgVKLocmjn2feToPdCGSLj2JiG05oTYMS9rJpK");
        article.setTitle("SQL Server 2008查询分析三种连接的区别");
        List<Article> list = new ArrayList<>();
        list.add(article);
        Article article2 = new Article();
        article2.setAuthor("莫问痴");
        article2.setContent("这只是一个测试用的图文消息");
        article2.setContent_source_url("http://www.qq.com");
        article2.setDigest("测试一下图文消息");
        article2.setShow_cover_pic(1);
        article2.setThumb_media_id("LyWpygZCpIcEYEu1NXlg9FIHzmmgVKLocmjn2feToPdCGSLj2JiG05oTYMS9rJpK");
        article2.setTitle("测试");
        list.add(article2);
        news.setArticles(list);
        MediaUploadRet ret = GroupMessageService.uploadNews(accessToken,news);
        Assert.assertNotNull(ret);
        logger.info(ret.getMedia_id());
        GroupMessageRet res = GroupMessageService.preview(accessToken,"o-SzhjpT1RWYi170nd9LwKXHj7-o",null,GroupMessageType.mpnews,ret.getMedia_id());
        Assert.assertNotNull(res);
        logger.info(res.getMsg_id()+"");
    }
}
