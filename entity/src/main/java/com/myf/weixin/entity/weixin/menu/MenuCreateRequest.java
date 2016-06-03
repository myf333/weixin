package com.myf.weixin.entity.weixin.menu;

import java.util.List;

/**
 * Created by myf on 2016/6/2.
 */
public class MenuCreateRequest {
    private List<Button> button;
    private MatchRule matchrule;

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }

    public MatchRule getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(MatchRule matchrule) {
        this.matchrule = matchrule;
    }
}
