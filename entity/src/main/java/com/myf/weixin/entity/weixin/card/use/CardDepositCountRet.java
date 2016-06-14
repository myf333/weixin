package com.myf.weixin.entity.weixin.card.use;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/14.
 */
public class CardDepositCountRet extends WxJsonResult{
    private int count;//已经成功存入的code数目。

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
