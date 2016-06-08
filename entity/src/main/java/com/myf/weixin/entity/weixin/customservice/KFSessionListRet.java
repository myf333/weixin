package com.myf.weixin.entity.weixin.customservice;

import com.myf.weixin.entity.weixin.WxJsonResult;

import java.util.List;

/**
 * Created by myf on 2016/6/8.
 */
public class KFSessionListRet extends WxJsonResult {
    private List<SessionListItem> sessionlist;

    public List<SessionListItem> getSessionlist() {
        return sessionlist;
    }

    public void setSessionlist(List<SessionListItem> sessionlist) {
        this.sessionlist = sessionlist;
    }
}
