package com.myf.weixin.entity.weixin.menu;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/3.
 */
public class AddConditionalRet extends WxJsonResult {
    private String menuid;

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }
}
