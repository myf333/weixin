package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.WxJsonResult;
import com.myf.weixin.entity.weixin.customservice.KFAccount;
import com.myf.weixin.entity.weixin.customservice.KFListRet;
import com.myf.weixin.util.HttpUtil;

import java.text.MessageFormat;

/**
 * Created by myf on 2016/6/7.
 * 请注意，必须先在公众平台官网为公众号设置微信号后才能使用该能力。
 */
public class CustomerService {
    /**
     * 添加客服帐号
     * 开发者可以通过本接口为公众号添加客服账号，每个公众号最多添加10个客服账号
     * **/
    public static WxJsonResult addKFAccount(String accessToken,KFAccount account)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/customservice/kfaccount/add?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,gson.toJson(account));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  修改客服帐号
     * **/
    public static WxJsonResult updateKFAccount(String accessToken,KFAccount account)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/customservice/kfaccount/update?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,gson.toJson(account));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  删除客服帐号
     * **/
    public static WxJsonResult delKFAccount(String accessToken,KFAccount account)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/customservice/kfaccount/del?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,gson.toJson(account));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  设置客服帐号的头像
     *  开发者可调用本接口来上传图片作为客服人员的头像，头像图片文件必须是jpg格式，推荐使用640*640大小的图片以达到最佳效果
     * **/
    public static WxJsonResult uploadHeadImg(String accessToken,String kf_account,String fileName,String filePath)throws Exception{
        String url = MessageFormat.format("http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token={0}&kf_account={1}",accessToken,kf_account);
        Gson gson = new Gson();
        String res = HttpUtil.UploadFile(url,null,"image",fileName,filePath);
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  获取所有客服账号
     *  开发者通过本接口，获取公众号中所设置的客服基本信息，包括客服工号、客服昵称、客服登录账号
     * **/
    public static KFListRet getKFList(String accessToken)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.Get(url,null);
        return gson.fromJson(res,KFListRet.class);
    }
}
