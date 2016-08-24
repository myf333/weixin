package com.myf.weixin.test;

import com.myf.weixin.entity.weixin.redpack.EpayResult;
import com.myf.weixin.entity.weixin.redpack.RedPackResult;
import com.myf.weixin.service.weixin.RedPackService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by myf on 2016/8/23.
 */

public class RedPackTest {
    @Test
    public void testSend() throws Exception{
        String certPath = "";
        String wxappid = "";
        String apisecret = "";
        String re_openid = "o757cvgnGCpcMEcNmsWaIdMmty_0";
        String mch_billno = "20160824182715862542237";
        String mch_id = "1301038901";
        String nick_name = "励拓技术服务";
        String send_name = "励拓技术服务";
        int total_amount = 100;
        String wishing = "测试";
        String client_ip = "10.0.60.34";
        String act_name = "红包";
        String remark = "红包";
        RedPackResult ret = RedPackService.sendRedPack(wxappid, apisecret, re_openid, mch_billno, mch_id, nick_name,
                send_name, total_amount, wishing, client_ip, act_name, remark, "", "", "", "", certPath);
        Assert.assertNotNull(ret);
    }

    @Test
    public void testEPay()throws Exception{
        String certPath = "";
        String wxappid = "";
        String apisecret = "";
        String mch_id = "1301038901";
        String mch_billno = "20160823182715962542238";
        String re_openid = "o757cvgnGCpcMEcNmsWaIdMmty_0";
        EpayResult ret = RedPackService.SendEnterprisePay(wxappid,apisecret,mch_id,mch_billno,re_openid,100,"测试","10.0.60.34",certPath);
        Assert.assertNotNull(ret);
    }

}
