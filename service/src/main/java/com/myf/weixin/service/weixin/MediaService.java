package com.myf.weixin.service.weixin;

import com.myf.weixin.util.FileUtil;
import com.myf.weixin.util.HttpUtil;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * Created by myf on 2016/5/23.
 */
public class MediaService {
    public static String getMedia(String accessToken,String mediaId,String savePath) throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/media/get?access_token={0}&media_id={1}", accessToken, mediaId);
        Response response = HttpUtil.Download(url, null);
        return FileUtil.saveWXMediaFile(response,savePath);
    }
}
