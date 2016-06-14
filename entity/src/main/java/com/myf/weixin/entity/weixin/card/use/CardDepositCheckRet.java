package com.myf.weixin.entity.weixin.card.use;

import com.myf.weixin.entity.weixin.WxJsonResult;

import java.util.List;

/**
 * Created by myf on 2016/6/14.
 */
public class CardDepositCheckRet extends WxJsonResult {
    private List<String> exist_code;//已经成功存入的code。
    private List<String> not_exist_code;//没有存入的code。

    public List<String> getExist_code() {
        return exist_code;
    }

    public void setExist_code(List<String> exist_code) {
        this.exist_code = exist_code;
    }

    public List<String> getNot_exist_code() {
        return not_exist_code;
    }

    public void setNot_exist_code(List<String> not_exist_code) {
        this.not_exist_code = not_exist_code;
    }
}
