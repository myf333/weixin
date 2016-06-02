package com.myf.weixin.entity.weixin.user;

import java.util.List;

/**
 * Created by myf on 2016/6/2.
 */
public class BatchTagRequest {
    private List<String> openid_list;
    private int tagid;

    public List<String> getOpenid_list() {
        return openid_list;
    }

    public void setOpenid_list(List<String> openid_list) {
        this.openid_list = openid_list;
    }

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }
}
