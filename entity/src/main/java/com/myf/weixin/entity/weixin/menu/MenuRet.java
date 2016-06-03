package com.myf.weixin.entity.weixin.menu;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/2.
 */
public class MenuRet extends WxJsonResult {
    private MenuItem menu;//默认菜单
    private MenuItem conditionalmenu;//个性化菜单列表

    public MenuItem getMenu() {
        return menu;
    }

    public void setMenu(MenuItem menu) {
        this.menu = menu;
    }

    public MenuItem getConditionalmenu() {
        return conditionalmenu;
    }

    public void setConditionalmenu(MenuItem conditionalmenu) {
        this.conditionalmenu = conditionalmenu;
    }
}
