package com.myf.weixin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by myf on 2016/5/4.
 */
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;// '用户id'
    private String account;//'账号'
    private String username;// '用户名'
    private String password;// '密码'
    private boolean binding;// '是否绑定'
    private String contactperson;// '联系人'
    private String contactphone;// '联系电话'
    private boolean state;// '是否有效'
    private String weixincode;// '微信公众号名称'
    private int weixintype;// '公众号类型'
    private String appid;//
    private String appsecret;//
    private String token;//
    private String encodingaeskey;//
    private String weixinbindsign;//'微信绑定标识'
    private String mch_id;//'微信支付商户号'
    private String apisecret;//'微信支付api秘钥'

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getBinding() {
        return binding;
    }

    public void setBinding(boolean binding) {
        this.binding = binding;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getWeixincode() {
        return weixincode;
    }

    public void setWeixincode(String weixincode) {
        this.weixincode = weixincode;
    }

    public int getWeixintype() {
        return weixintype;
    }

    public void setWeixintype(int weixintype) {
        this.weixintype = weixintype;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncodingaeskey() {
        return encodingaeskey;
    }

    public void setEncodingaeskey(String encodingaeskey) {
        this.encodingaeskey = encodingaeskey;
    }

    public String getWeixinbindsign() {
        return weixinbindsign;
    }

    public void setWeixinbindsign(String weixinbindsign) {
        this.weixinbindsign = weixinbindsign;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getApisecret() {
        return apisecret;
    }

    public void setApisecret(String apisecret) {
        this.apisecret = apisecret;
    }
}
