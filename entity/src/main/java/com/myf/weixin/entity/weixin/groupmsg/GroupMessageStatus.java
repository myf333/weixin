package com.myf.weixin.entity.weixin.groupmsg;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/1.
 */
public class GroupMessageStatus extends WxJsonResult {
    private long msg_id;//群发消息后返回的消息id
    private String msg_status;//消息发送后的状态，SEND_SUCCESS表示发送成功

    public long getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(long msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_status() {
        return msg_status;
    }

    public void setMsg_status(String msg_status) {
        this.msg_status = msg_status;
    }
}
