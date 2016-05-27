package com.myf.weixin.test;

import com.myf.weixin.entity.Account;
import com.myf.weixin.entity.weixin.PostModel;
import com.myf.weixin.entity.weixin.RequestMessage;
import com.myf.weixin.service.AccountService;
import com.myf.weixin.service.weixin.MessageHandler;
import com.myf.weixin.util.CheckSignature;
import com.myf.weixin.util.XMLConvertUtil;
import com.qq.weixin.mp.aes.AesException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
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

    @Autowired
    private MessageHandler messageHandler;

    @Autowired
    private BeanFactory beanFactory;

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
        //MessageHandler handler = new MessageHandler( new ByteArrayInputStream(xml.getBytes()),new PostModel());
        MessageHandler messageHandler1 = beanFactory.getBean(MessageHandler.class);
        messageHandler1.setModel(new PostModel());
        messageHandler1.Init( new ByteArrayInputStream(xml.getBytes()));
        messageHandler1.execute();
        String res = messageHandler1.getResponse();
        Assert.assertNotEquals("",res);
    }

    @Test
    public void testWeiXinRequestMessage(){
        String xml = "<xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>\n" +
                "<FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>\n" +
                "<CreateTime>1408090816</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[pic_weixin]]></Event>\n" +
                "<EventKey><![CDATA[6]]></EventKey>\n" +
                "<SendPicsInfo><Count>1</Count>\n" +
                "<PicList><item><PicMd5Sum><![CDATA[5a75aaca956d97be686719218f275c6b]]></PicMd5Sum>\n" +
                "</item>\n" +
                "</PicList>\n" +
                "</SendPicsInfo>\n" +
                "</xml>";
        RequestMessage msg = XMLConvertUtil.convertToObject(RequestMessage.class,xml);
        Assert.assertNotNull(msg);
        xml = "<xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>\n" +
                "<FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>\n" +
                "<CreateTime>1408091189</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[location_select]]></Event>\n" +
                "<EventKey><![CDATA[6]]></EventKey>\n" +
                "<SendLocationInfo><Location_X><![CDATA[23]]></Location_X>\n" +
                "<Location_Y><![CDATA[113]]></Location_Y>\n" +
                "<Scale><![CDATA[15]]></Scale>\n" +
                "<Label><![CDATA[ 广州市海珠区客村艺苑路 106号]]></Label>\n" +
                "<Poiname><![CDATA[]]></Poiname>\n" +
                "</SendLocationInfo>\n" +
                "</xml>";
        RequestMessage msg1 = XMLConvertUtil.convertToObject(RequestMessage.class,xml);
        Assert.assertNotNull(msg1);
        xml = "<xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>\n" +
                "<FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>\n" +
                "<CreateTime>1408090606</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[scancode_waitmsg]]></Event>\n" +
                "<EventKey><![CDATA[6]]></EventKey>\n" +
                "<ScanCodeInfo><ScanType><![CDATA[qrcode]]></ScanType>\n" +
                "<ScanResult><![CDATA[2]]></ScanResult>\n" +
                "</ScanCodeInfo>\n" +
                "</xml>";
        RequestMessage msg2 = XMLConvertUtil.convertToObject(RequestMessage.class,xml);
        Assert.assertNotNull(msg2);
    }
}
