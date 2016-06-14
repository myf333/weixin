package com.myf.weixin.entity.weixin.card.use;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/14.
 */
public class CardDepositRet extends WxJsonResult {
    private int succ_code;//成功个数
    private int duplicate_code;//重复导入的code会自动被过滤
    private int fail_code;//失败个数。

    public int getSucc_code() {
        return succ_code;
    }

    public void setSucc_code(int succ_code) {
        this.succ_code = succ_code;
    }

    public int getDuplicate_code() {
        return duplicate_code;
    }

    public void setDuplicate_code(int duplicate_code) {
        this.duplicate_code = duplicate_code;
    }

    public int getFail_code() {
        return fail_code;
    }

    public void setFail_code(int fail_code) {
        this.fail_code = fail_code;
    }
}
