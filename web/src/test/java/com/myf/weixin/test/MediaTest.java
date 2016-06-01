package com.myf.weixin.test;

import com.myf.weixin.entity.weixin.media.*;
import com.myf.weixin.service.weixin.AccessTokenService;
import com.myf.weixin.service.weixin.MediaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by myf on 2016/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:servlet-context.xml"})
public class MediaTest {
    @Autowired
    private AccessTokenService tokenService;

    @Value("${media.savePath}")
    private String savePath;

    @Test
    public void testGetMaterialCount() throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);
        MaterialCount count = MediaService.getMaterialCount(accessToken);
        Assert.assertNotNull(count);
    }

    @Test
    public void testBatchGetMaterial() throws Exception{
        String appId = "wxc3063aee2db008c0";
        String appSecret="b4b58f2cdecc3037ac56704796275a37";
        String accessToken = tokenService.GetAccessToken(appId,appSecret);

        MaterialBatchGet ret = MediaService.batchGetMaterial(accessToken, MediaType.image,1,20);
        Assert.assertNotNull(ret);
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
}
