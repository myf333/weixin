package com.myf.weixin.entity.weixin.menu;

import java.util.List;

/**
 * Created by myf on 2016/6/2.
 */
public class MenuItem {
    private List<Button> button;
    private long menuid;
    private MatchRule matchrule;

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }

    public long getMenuid() {
        return menuid;
    }

    public void setMenuid(long menuid) {
        this.menuid = menuid;
    }

    public MatchRule getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(MatchRule matchrule) {
        this.matchrule = matchrule;
    }
}
