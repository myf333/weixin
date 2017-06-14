package com.myf.weixin.entity.weixin.card.create;

/**
 * Created by myf on 2017/6/14.
 */
public class MemberCard extends CardInfoBase {
    private String background_pic_url ;//商家自定义会员卡背景图，须先调用上传图片接口将背景图上传至CDN，否则报错，卡面设计请遵循微信会员卡自定义背景设计规范  ,像素大小控制在1000像素*600像素以下
    private String prerogative  ;// 是   string（3072）会员卡特权说明。
    private boolean auto_activate ;//  否   bool   设置为true时用户领取会员卡后系统自动将其激活，无需调用激活接口，详情见自动激活。
    private boolean wx_activate ;// 否   bool   设置为true时会员卡支持一键开卡，不允许同时传入activate_url字段，否则设置wx_activate失效。填入该字段后仍需调用接口设置开卡项方可生效，详情见一键开卡。
    private boolean supply_bonus ;//是   bool   显示积分，填写true或false，如填写true，积分相关字段均为必填。
    private String bonus_url  ;// 否   string(128)   设置跳转外链查看积分详情。仅适用于积分无法通过激活接口同步的情况下使用该字段。
    private boolean supply_balance  ;// 是   bool   是否支持储值，填写true或false。如填写true，储值相关字段均为必填。
    private String balance_url ;//  否   string(128)   设置跳转外链查看余额详情。仅适用于余额无法通过激活接口同步的情况下使用该字段。
    private CustomField custom_field1 ;//  否   JSON结构   自定义会员信息类目，会员卡激活后显示,包含name_type(name)和url字段
    private CustomField custom_field2 ;// 否   JSON结构   自定义会员信息类目，会员卡激活后显示，包含name_type(name)和url字段
    private CustomField custom_field3 ;//  否   JSON结构   自定义会员信息类目，会员卡激活后显示，包含name_type(name)和url字段
    private String bonus_cleared ;//  否   string（128）   积分清零规则。
    private String bonus_rules;//  否   string（128）   积分规则。
    private String balance_rules;//  否   string（128）   储值说明。
    private String activate_url;//  是   string（128）   激活会员卡的url。
    private CustomCell custom_cell1;//  否   JSON结构   自定义会员信息类目，会员卡激活后显示。
    private BonusRule bonus_rule;// 否   JSON结构      	积分规则。
    public int discount;//否   int   折扣，该会员卡享受的折扣优惠,填10就是九折。
}
