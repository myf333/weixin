package com.myf.weixin.entity.weixin.message;

import com.myf.weixin.util.XStreamCDATA;

/**
 * Created by myf on 2016/6/12.
 */
public class KFAccount {
    @XStreamCDATA
    private String KfAccount;

    public String getKfAccount() {
        return KfAccount;
    }

    public void setKfAccount(String kfAccount) {
        KfAccount = kfAccount;
    }
}
