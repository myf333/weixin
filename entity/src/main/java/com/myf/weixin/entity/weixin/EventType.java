package com.myf.weixin.entity.weixin;

/**
 * Created by myf on 2016/5/20.
 */
public enum EventType {
    subscribe,//订阅
    unsubscribe,//取消订阅
    scan,//二维码扫描
    LOCATION,//上报地理位置
    CLICK,//CLICK
    VIEW,//VIEW
    scancode_push,//扫码推事件
    scancode_waitmsg,//扫码推事件且弹出“消息接收中”提示框
    pic_sysphoto,//弹出系统拍照发图
    pic_photo_or_album,//弹出拍照或者相册发图
    pic_weixin,//弹出微信相册发图器
    location_select,//弹出地理位置选择器
    MASSSENDJOBFINISH,//事件推送群发结果
    TEMPLATESENDJOBFINISH,//事件推送模板消息结果
    poi_check_notify,//新创建的门店在审核通过后，会以事件形式推送给商户填写的回调URL
    card_pass_check,//卡券审核通过
    card_not_pass_check,//卡券审核不通过
    user_pay_from_pay_cell,//买单事件推送
}
