package com.myf.weixin.test;

import com.myf.weixin.entity.Account;
import com.myf.weixin.entity.weixin.PostModel;
import com.myf.weixin.entity.weixin.RequestMsgType;
import com.myf.weixin.service.AccountService;
import com.myf.weixin.service.weixin.MessageHandler;
import com.myf.weixin.util.CheckSignature;
import com.myf.weixin.util.XMLConvertUtil;
import com.qq.weixin.mp.aes.AesException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayInputStream;

/**
 * Created by myf on 2016/5/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class WeiXinTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void testWeiXinSign(){
        //WeiXinController controller = new WeiXinController();
        String timestamp = "1348831860";
        String nonce = "123456";
        String signature = "64df36bc8ba4d7bfcb7742bfe99226cb026059a2";
        String sign = "1234567";

        Account account = accountService.findAccountBySign(sign);
        Assert.assertNotNull(account);
        boolean isSignature = CheckSignature.Check(signature, timestamp, nonce, account.getToken());
        Assert.assertTrue(isSignature);
    }

    @Test
    public void testMessageHandlerNews() throws AesException {
        String xml = "<xml>\n" +
                " <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                " <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                " <CreateTime>1348831860</CreateTime>\n" +
                " <MsgType><![CDATA[image]]></MsgType>\n" +
                " <PicUrl><![CDATA[this is a url]]></PicUrl>\n" +
                " <MediaId><![CDATA[media_id]]></MediaId>\n" +
                " <MsgId>1234567890123456</MsgId>\n" +
                " </xml>";
        MessageHandler handler = new MessageHandler( new ByteArrayInputStream(xml.getBytes()),new PostModel());
        handler.execute();
        String res = handler.getResponse();
        Assert.assertNotEquals("",res);
    }
}
