package com.myf.weixin.test;

import com.myf.weixin.entity.weixin.media.*;
import com.myf.weixin.entity.weixin.RequestMessage;
import com.myf.weixin.service.weixin.AccessTokenService;
import com.myf.weixin.service.weixin.MediaService;
import com.myf.weixin.util.XMLConvertUtil;
import com.myf.weixin.util.XStreamCDATA;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by myf on 2016/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class CommonTest {
    @Autowired
    private AccessTokenService tokenService;

    @Value("${media.savePath}")
    private String savePath;

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

    @Test
    public void testMediaDownload() throws Exception{
        String mediaId="ufrpyR2NLkPnbwyzMn13d_K3ZMtdtZlYZVcAg1jZfHPlmURXOOUBbPVY2p5zXKF3";
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        String filePath = MediaService.getMedia(accessToken,mediaId,savePath);
        Assert.assertNotNull(filePath);
    }

    @Test
    public void testUploadMediaFile() throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        MediaUploadRet res = MediaService.uploadMedia(accessToken, MediaType.image.toString(),"600x600.jpg", "d:\\600x600.jpg");
        Assert.assertNotNull(res);
        Assert.assertEquals("image", res.getType());
    }

    @Test
    public void testUploadMaterialVideo() throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        VideoUploadRequest info = new VideoUploadRequest();
        info.setIntroduction("这是一条测试视频");
        info.setTitle("测试音乐");
        MaterialUploadRet res = MediaService.uploadMaterial(accessToken,MediaType.video.toString(),"ccc.mp4","d:\\ccc.mp4",info);
        Assert.assertNotNull(res);
    }

    @Test
    public void testUploadMaterialImage() throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        MaterialUploadRet res = MediaService.uploadMaterial(accessToken, MediaType.image.toString(), "600x600.jpg", "d:\\600x600.jpg",null);
        Assert.assertNotNull(res);
    }

    @Test
    public void testUploadMediaImg() throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        MediaUploadImgRet res = MediaService.uploadImg(accessToken,"600x600.jpg", "d:\\600x600.jpg");
        Assert.assertNotNull(res);
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
