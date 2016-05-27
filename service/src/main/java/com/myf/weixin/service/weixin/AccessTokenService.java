package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.myf.weixin.entity.weixin.AccessTokenResult;
import com.myf.weixin.util.HttpUtil;
import com.myf.weixin.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * Created by myf on 2016/5/23.
 */
@Service("AccessTokenService")
public class AccessTokenService {
    @Autowired
    private RedisUtil redis;

    public String GetAccessToken(String appId, String appSecret) throws Exception{
        String key = String.format("%s:accessToken", appId);
        String access_token = redis.GetKey(key);
        if("".equals(access_token)||null==access_token||"null".equals(access_token)){
            String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}&secret={1}",appId,appSecret);
            String res = HttpUtil.Get(url,null);
            if(!"".equals(res)) {
                Gson gson = new GsonBuilder().create();
                AccessTokenResult ret = gson.fromJson(res, AccessTokenResult.class);
                if(ret.getErrcode() == 0){
                    access_token = ret.getAccess_token();
                    redis.SetKey(key,access_token,ret.getExpires_in());
                }
            }
        }
        return access_token;
    }
}
