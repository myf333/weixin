package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.qrcode.Long2ShortRet;
import com.myf.weixin.entity.weixin.qrcode.QrCodeRet;
import com.myf.weixin.entity.weixin.qrcode.QrSceneType;
import com.myf.weixin.util.HttpUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;

/**
 * Created by myf on 2016/6/6.
 * 为了满足用户渠道推广分析和用户帐号绑定等场景的需要，公众平台提供了生成带参数二维码的接口。
 * 使用该接口可以获得多个带不同场景值的二维码，用户扫描后，公众号可以接收到事件推送。
 * 用户扫描带场景值二维码时，可能推送以下两种事件：
 * 如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
 * 如果用户已经关注公众号，在用户扫描后会自动进入会话，微信也会将带场景值扫描事件推送给开发者。
 * 获取带参数的二维码的过程包括两步，首先创建二维码ticket，然后凭借ticket到指定URL换取二维码。
 */
public class QrCodeService {
    /**
     * 创建二维码ticket
     * 目前有2种类型的二维码：
     * 1、临时二维码，是有过期时间的，最长可以设置为在二维码生成后的30天（即2592000秒）后过期，但能够生成较多数量。临时二维码主要用于帐号绑定等不要求二维码永久保存的业务场景
     * 2、永久二维码，是无过期时间的，但数量较少（目前为最多10万个）。永久二维码主要用于适用于帐号绑定、用户来源统计等场景。
     * **/
    public static QrCodeRet createQrCode(String accessToken,QrSceneType type,int sceneId,String sceneStr,long expire_seconds)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token={0}",accessToken);
        String json = "";
        switch (type){
            case QR_SCENE:
                json = String.format("{\"expire_seconds\": %d, \"action_name\": \"%s\", \"action_info\": {\"scene\": {\"scene_id\": %d}}}",expire_seconds,type.toString(),sceneId);
                break;
            case QR_LIMIT_SCENE:
                json = String.format("{\"action_name\": \"%s\", \"action_info\": {\"scene\": {\"scene_id\": %d}}}",type.toString(),sceneId);
                break;
            case QR_LIMIT_STR_SCENE:
                json = String.format("{\"action_name\": \"%s\", \"action_info\": {\"scene\": {\"scene_str\": \"%s\"}}}",type.toString(),sceneStr);
                break;
        }
        String res = HttpUtil.postJson(url,json);
        Gson gson = new Gson();
        return gson.fromJson(res,QrCodeRet.class);
    }

    /**
     * 通过ticket换取二维码
     * **/
    public static String showQrCode(String ticket) throws UnsupportedEncodingException{
        return MessageFormat.format("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket={0}", URLEncoder.encode(ticket,"UTF-8"));
    }

    /**
     *长链接转短链接接口
     * 主要使用场景： 开发者用于生成二维码的原链接（商品、支付二维码等）太长导致扫码速度和成功率下降，
     * 将原长链接通过此接口转成短链接再生成二维码将大大提升扫码速度和成功率。
     * **/
    public static Long2ShortRet long2Short(String accessToken,String long_url)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/shorturl?access_token={0}",accessToken);
        String json = String.format("{\"action\":\"long2short\",\"long_url\":\"%s\"}",long_url);
        String res = HttpUtil.postJson(url,json);
        Gson gson = new Gson();
        return gson.fromJson(res,Long2ShortRet.class);
    }
}
