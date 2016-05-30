package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.media.*;
import com.myf.weixin.util.FileUtil;
import com.myf.weixin.util.HttpUtil;
import com.squareup.okhttp.Response;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by myf on 2016/5/23.
 */
public class MediaService {
    /*
    * 公众号可以使用本接口获取临时素材（即下载临时的多媒体文件）
    * */
    public static String getMedia(String accessToken,String mediaId,String savePath) throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/media/get?access_token={0}&media_id={1}", accessToken, mediaId);
        Response response = HttpUtil.Download(url, null);
        return FileUtil.saveWXMediaFile(response,savePath);
    }

    /*
    * 通过本接口，公众号可以新增临时素材（即上传临时多媒体文件）
    * */
    public static MediaUploadRet uploadMedia(String accessToken,String mediaType,String fileName,String filePath) throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/media/upload?access_token={0}&type={1}", accessToken, mediaType);
        String res =  HttpUtil.UploadFile(url,null,"media",fileName,filePath);
        Gson gson = new Gson();
        return gson.fromJson(res,MediaUploadRet.class);
    }

    /*
    * 本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式
    * 在图文消息的具体内容中，将过滤外部的图片链接，开发者可以通过下述接口上传图片得到URL，放到图文内容中使用
    * */
    public static MediaUploadImgRet uploadImg(String accessToken,String fileName,String filePath) throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token={0}", accessToken);
        String res =  HttpUtil.UploadFile(url,null,"media",fileName,filePath);
        Gson gson = new Gson();
        return gson.fromJson(res,MediaUploadImgRet.class);
    }

    /*
    * 新增其他类型永久素材
    * */
    public static MaterialUploadRet uploadMaterial(String accessToken,String mediaType,String fileName,String filePath,VideoUploadRequest videoInfo) throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/material/add_material?access_token={0}&type={1}", accessToken, mediaType);
        Map<String,String> map = new HashMap<>();
        Gson gson = new Gson();
        if(MediaType.valueOf(mediaType) == MediaType.video){
            if(videoInfo!=null){
                map.put("description",gson.toJson(videoInfo));
            }
        }
        String res =  HttpUtil.UploadFile(url,map,"media",fileName,filePath);

        return gson.fromJson(res,MaterialUploadRet.class);
    }
}
