package com.myf.weixin.entity.weixin.groupmsg;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/1.
 */
public class GroupMessageRet extends WxJsonResult {
    private String type;
    private long msg_id;
    private long msg_data_id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(long msg_id) {
        this.msg_id = msg_id;
    }

    public long getMsg_data_id() {
        return msg_data_id;
    }

    public void setMsg_data_id(long msg_data_id) {
        this.msg_data_id = msg_data_id;
    }
}
