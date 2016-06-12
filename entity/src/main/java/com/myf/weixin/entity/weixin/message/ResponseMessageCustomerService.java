package com.myf.weixin.entity.weixin.message;

import com.myf.weixin.entity.weixin.ResponseMessageBase;

/**
 * Created by myf on 2016/6/12.
 */
public class ResponseMessageCustomerService extends ResponseMessageBase {
    private KFAccount TransInfo;

    public KFAccount getTransInfo() {
        return TransInfo;
    }

    public void setTransInfo(KFAccount transInfo) {
        TransInfo = transInfo;
    }
}
