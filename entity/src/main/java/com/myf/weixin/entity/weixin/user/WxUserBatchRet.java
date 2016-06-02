package com.myf.weixin.entity.weixin.user;

import com.myf.weixin.entity.weixin.WxJsonResult;

import java.util.List;

/**
 * Created by myf on 2016/6/2.
 */
public class WxUserBatchRet extends WxJsonResult{
    private List<WxUserInfoRet> user_info_list;

    public List<WxUserInfoRet> getUser_info_list() {
        return user_info_list;
    }

    public void setUser_info_list(List<WxUserInfoRet> user_info_list) {
        this.user_info_list = user_info_list;
    }
}
