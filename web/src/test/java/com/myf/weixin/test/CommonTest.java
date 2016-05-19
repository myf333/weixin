package com.myf.weixin.test;

import com.myf.weixin.util.XMLConvertUtil;
import com.myf.weixin.util.XStreamCDATA;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by myf on 2016/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class CommonTest {
    @Test
    public void testXmlParse(){
        String xml = "<xml>\n" +
                "<ToUserName><![CDATA[ddd]]></ToUserName>\n" +
                "<Encrypt><![CDATA[你好呀]]></Encrypt>\n" +
                //"<Encrypt2><![CDATA[dsdsdsdsd]]></Encrypt2>\n" +
                "</xml>";

        WEntity entity = XMLConvertUtil.convertToObject(WEntity.class, xml);
        Assert.assertNotNull(entity);
        String xml2 = XMLConvertUtil.toXML(WEntity.class,entity);
        Assert.assertNotEquals("",xml2);
    }

    class WEntity{
        @XStreamCDATA
        private String ToUserName;
        private String Encrypt;

        public String getToUserName() {
            return ToUserName;
        }

        public void setToUserName(String toUserName) {
            ToUserName = toUserName;
        }

        public String getEncrypt() {
            return Encrypt;
        }

        public void setEncrypt(String encrypt) {
            Encrypt = encrypt;
        }
    }
}
