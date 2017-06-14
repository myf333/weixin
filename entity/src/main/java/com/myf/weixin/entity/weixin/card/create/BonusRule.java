package com.myf.weixin.entity.weixin.card.create;

/**
 * Created by myf on 2017/6/14.
 */
public class BonusRule {
    private int cost_money_unit;//否 int 消费金额。以分为单位。
    private int increase_bonus ;// 否 int 对应增加的积分。
    private int max_increase_bonus ;//否	int 用户单次可获取的积分上限。
    private int init_increase_bonus ;//否 int 初始设置积分。
    private int cost_bonus_unit ;//否 int 每使用5积分。
    private int reduce_money;//否  int  抵扣xx元，（这里以分为单位）
    private int least_money_to_use_bonus ;// 否 int 抵扣条件，满xx元（这里以分为单位）可用。
    private int max_reduce_bonus;//否 int 抵扣条件，单笔最多使用xx积分。
}
