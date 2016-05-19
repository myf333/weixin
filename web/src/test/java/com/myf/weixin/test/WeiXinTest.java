package com.myf.weixin.test;

import com.myf.weixin.entity.Account;
import com.myf.weixin.entity.weixin.RequestMsgType;
import com.myf.weixin.service.AccountService;
import com.myf.weixin.util.CheckSignature;
import com.myf.weixin.util.XMLConvertUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
