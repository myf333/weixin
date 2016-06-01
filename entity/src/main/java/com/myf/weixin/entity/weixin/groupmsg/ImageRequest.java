package com.myf.weixin.entity.weixin.groupmsg;

/**
 * Created by myf on 2016/6/1.
 */
public class ImageRequest extends GroupMessageRequest {
    private GroupFilter filter;
    private MediaContent image;

    public GroupFilter getFilter() {
        return filter;
    }

    public void setFilter(GroupFilter filter) {
        this.filter = filter;
    }

    public MediaContent getImage() {
        return image;
    }

    public void setImage(MediaContent image) {
        this.image = image;
    }
}
