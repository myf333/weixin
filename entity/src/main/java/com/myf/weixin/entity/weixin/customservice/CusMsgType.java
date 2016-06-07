package com.myf.weixin.entity.weixin.customservice;

/**
 * Created by myf on 2016/6/7.
 */
public enum CusMsgType {
    text,//发送文本消息
    image,//发送图片消息
    voice,//发送语音消息
    video,//发送视频消息
    music,//发送音乐消息
    news,//发送图文消息（点击跳转到外链）
    mpnews,//发送图文消息（点击跳转到图文消息页面）
    wxcard,//发送卡券
}
