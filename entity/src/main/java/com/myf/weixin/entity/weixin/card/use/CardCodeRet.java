package com.myf.weixin.entity.weixin.card.use;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/22.
 */
public class CardCodeRet extends WxJsonResult{
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
