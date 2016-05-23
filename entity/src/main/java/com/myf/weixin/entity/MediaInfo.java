package com.myf.weixin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by myf on 2016/5/20.
 */
@Entity(name = "mediainfo")
public class MediaInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;// 'id'
    private long accountId;
    private String wxMediaId;
    private String mediatype;
    private Date inputdate;
    private String mediaurl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getWxMediaId() {
        return wxMediaId;
    }

    public void setWxMediaId(String wxMediaId) {
        this.wxMediaId = wxMediaId;
    }

    public String getMediatype() {
        return mediatype;
    }

    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public String getMediaurl() {
        return mediaurl;
    }

    public void setMediaurl(String mediaurl) {
        this.mediaurl = mediaurl;
    }
}
