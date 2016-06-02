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

}
