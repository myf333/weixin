package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.WxJsonResult;
import com.myf.weixin.entity.weixin.user.*;
import com.myf.weixin.util.HttpUtil;

import java.text.MessageFormat;

/**
 * Created by myf on 2016/6/2.
 */
public class UserService {
    /**
     * 创建标签 一个公众号，最多可以创建100个标签。
     * **/
    public static TagCreateRet createTag(String accessToken,String name)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/tags/create?access_token={0}",accessToken);
        String res = HttpUtil.postJson(url,String.format("{\"tag\" : {\"name\" : \"%s\"}}",name));
        Gson gson = new Gson();
        return gson.fromJson(res,TagCreateRet.class);
    }

    /**
     * 获取公众号已创建的标签
     * **/
    public static TagListRet getTagList(String accessToken)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/tags/get?access_token={0}",accessToken);
        String res = HttpUtil.Get(url,null);
        Gson gson = new Gson();
        return gson.fromJson(res,TagListRet.class);
    }

    /**
     * 编辑标签
     * **/
    public static WxJsonResult updateTag(String accessToken,int id,String name)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/tags/update?access_token={0}",accessToken);
        String res = HttpUtil.postJson(url, String.format("{\"tag\" : {\"id\" : %d,\"name\" : \"%s\"}}",id,name));
        Gson gson = new Gson();
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     * 删除标签
     * **/
    public static WxJsonResult deleteTag(String accessToken,int id)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/tags/delete?access_token={0}",accessToken);
        String res = HttpUtil.postJson(url, String.format("{\"tag\" : {\"id\" : %d}}",id));
        Gson gson = new Gson();
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     * 获取标签下粉丝列表
     * openId   第一个拉取的OPENID，不填默认从头开始拉取
     * **/
    public static TagOpenIdListRet getTagOpenIdList(String accessToken,int id,String openId)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token={0}",accessToken);
        String res = HttpUtil.postJson(url, String.format("{\"tagid\" : %d,\"next_openid\":\"%s\"}",id,openId));
        Gson gson = new Gson();
        return gson.fromJson(res,TagOpenIdListRet.class);
    }

    /**
     * 批量为用户打标签
     * 标签功能目前支持公众号为用户打上最多三个标签。
     * **/
    public static WxJsonResult batchTagging(String accessToken,BatchTagRequest request)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url, gson.toJson(request));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     * 批量为用户取消标签
     * **/
    public static WxJsonResult batchUnTagging(String accessToken,BatchTagRequest request)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url, gson.toJson(request));
        return gson.fromJson(res,WxJsonResult.class);
    }
    /**
     * 获取用户身上的标签列表
     * **/
    public static UserTagRet getUserTagList(String accessToken,String openId)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url, String.format("{\"openid\" : \"%s\"}",openId));
        return gson.fromJson(res,UserTagRet.class);
    }

    /**
     * 设置用户备注名 该接口暂时开放给微信认证的服务号
     * **/
    public static WxJsonResult updateRemark(String accessToken,String openId,String remark)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url, String.format("{\"openid\":\"%s\",\"remark\":\"%s\"}",openId,remark));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     * 获取用户基本信息（包括UnionID机制）
     * **/
    public static WxUserInfoRet getUserInfo(String accessToken,String openId)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/user/info?access_token={0}&openid={1}&lang=zh_CN",accessToken,openId);
        String res = HttpUtil.Get(url,null);
        Gson gson = new Gson();
        return gson.fromJson(res,WxUserInfoRet.class);
    }

    /**
     * 批量获取用户基本信息
     * 开发者可通过该接口来批量获取用户基本信息。最多支持一次拉取100条。
     * **/
    public static WxUserBatchRet getUserInfoBatch(String accessToken,BatchUserRequest request)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,gson.toJson(request));
        return gson.fromJson(res,WxUserBatchRet.class);
    }

    /**
     * 公众号可通过本接口来获取帐号的关注者列表，关注者列表由一串OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
     * 一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
     * **/
    public static OpenIdListRet getOpenIdList(String accessToken,String openId)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/user/get?access_token={0}&next_openid={1}",accessToken,openId);
        String res = HttpUtil.Get(url,null);
        Gson gson = new Gson();
        return gson.fromJson(res,OpenIdListRet.class);
    }
}
