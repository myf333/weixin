package com.myf.weixin.entity.weixin.groupmsg;

/**
 * Created by myf on 2016/6/1.
 */
public class GroupFilter {
    private boolean is_to_all;
    private int tag_id;

    public boolean isIs_to_all() {
        return is_to_all;
    }

    public void setIs_to_all(boolean is_to_all) {
        this.is_to_all = is_to_all;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }
}
