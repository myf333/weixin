package com.myf.weixin.test;

import com.myf.weixin.entity.weixin.RequestMessage;
import com.myf.weixin.util.XMLConvertUtil;
import com.myf.weixin.util.XStreamCDATA;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
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

    @Test
    public void testDecryptMsg() throws AesException{
        String xml = "<xml>\n" +
                "    <ToUserName><![CDATA[gh_b1e747297f00]]></ToUserName>\n" +
                "    <Encrypt><![CDATA[iI5LDluucxHlaQJVteAiS3d5SX+9rWtoCabmq/ZMMTehSuWsi/U4vLSNjgnMacWLw4NjwCU+eyu31qNB4+oOz/UmAnFavESEQAgO1L4nmXhZjejGCaIMqr+A5JBIFEUDrR3N3kN8yav8paxmxAyDIn+8+FDm9GNk6yaD+er8KYOVmx81WnNz63jznXE9IilxUOyG13L0jrTdGJYXiqxEWCwwFNZ2QzyYFZtJmE6zaUEKKwc9vqhCdNVTlmoj/aK3AKxXe3Dz1RVfYmuR6W+Nzy4wk1yMsV3aiNR9XKvok/VYFBuXNMJKPh55XnLd9SlZrrdpeFB7e4vztwOzAHqEWqs9kmW2TAjJ31AbX4EB3ni5Qdqq/Zubrn1rzZESU58iUz26V4bL/UvbXBLJ4tzZCxCNXufLCpU0AKeqBFGEmSKefGQY1AR4g2pXIXDsevj5SIQJbMifajn+igBBg12UQA==]]></Encrypt>\n" +
                "</xml>";
        WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt("49ba59abbe56e", "kyRRviPkElu1i5KiUXiOObBgPkrMblh9OvOjI5eXRLy", "wx775e83af2372e593");
        xml = wxBizMsgCrypt.decryptMsg("c64fe6527970ffe27effd7b50a0e69f44f19f199","1463639270", "998914514", xml);
        Assert.assertNotEquals("",xml);
        RequestMessage requestMessage = XMLConvertUtil.convertToObject(RequestMessage.class,xml);
        Assert.assertNotNull(requestMessage);
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
