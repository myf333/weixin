package com.myf.weixin.entity.weixin.card.use;

/**
 * Created by myf on 2016/6/14.
 */
public enum CardUseStatus {
    NORMAL, //      正常
    CONSUMED,//     已核销
    EXPIRE,  //     已过期
    GIFTING ,  //   转赠中
    GIFT_TIMEOUT,// 转赠超时
    DELETE , //     已删除
    UNAVAILABLE, // 已失效
}
