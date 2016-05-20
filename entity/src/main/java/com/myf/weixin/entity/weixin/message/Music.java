package com.myf.weixin.entity.weixin.message;

import com.myf.weixin.util.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by myf on 2016/5/19.
 */
@XStreamAlias("Music")
public class Music {
    @XStreamCDATA
    private String Title;
    @XStreamCDATA
    private String Description;
    @XStreamCDATA
    private String MusicUrl;
    @XStreamCDATA
    private String HQMusicUrl ;
    /**
     *  缩略图的媒体id，通过上传多媒体文件，得到的id
     * */
    private String ThumbMediaId ;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMusicUrl() {
        return MusicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        MusicUrl = musicUrl;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
