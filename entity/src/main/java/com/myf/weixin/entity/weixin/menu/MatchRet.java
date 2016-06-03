package com.myf.weixin.entity.weixin.menu;

import com.myf.weixin.entity.weixin.WxJsonResult;

import java.util.List;

/**
 * Created by myf on 2016/6/3.
 */
public class MatchRet extends WxJsonResult {
    private List<Button> button;

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }
}
