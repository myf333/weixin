package com.myf.weixin.entity.weixin.user;

import java.util.List;

/**
 * Created by myf on 2016/6/2.
 */
public class BatchUserRequest {
    private List<BatchUserItem> user_list;

    public List<BatchUserItem> getUser_list() {
        return user_list;
    }

    public void setUser_list(List<BatchUserItem> user_list) {
        this.user_list = user_list;
    }
}
