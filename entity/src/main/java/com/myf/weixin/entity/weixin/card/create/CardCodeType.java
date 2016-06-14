package com.myf.weixin.entity.weixin.card.create;

/**
 * Created by myf on 2016/6/12.
 */
public enum CardCodeType {
    CODE_TYPE_TEXT,//文本；
    CODE_TYPE_BARCODE,//一维码
    CODE_TYPE_QRCODE,//二维码
    CODE_TYPE_ONLY_QRCODE,//二维码无code显示；
    CODE_TYPE_ONLY_BARCODE,//一维码无code显示;
    CODE_TYPE_NONE,//不显示code和条形码类型
}
