package com.myf.weixin.entity.weixin.user;

import com.myf.weixin.entity.weixin.WxJsonResult;

import java.util.List;

/**
 * Created by myf on 2016/6/2.
 */
public class UserTagRet extends WxJsonResult{
    private List<Integer> tagid_list;

    public List<Integer> getTagid_list() {
        return tagid_list;
    }

    public void setTagid_list(List<Integer> tagid_list) {
        this.tagid_list = tagid_list;
    }
}
