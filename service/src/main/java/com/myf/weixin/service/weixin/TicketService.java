package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.JsAPITicketResult;
import com.myf.weixin.entity.weixin.TicketType;
import com.myf.weixin.util.HttpUtil;

import java.text.MessageFormat;

/**
 * Created by myf on 2016/6/14.
 */
public class TicketService {
    /**
     * 获取api_ticket
     * **/
    public static JsAPITicketResult getTicket(String accessToken,TicketType type)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token={0}&type={1}",accessToken,type.toString());
        Gson gson = new Gson();
        String res = HttpUtil.Get(url,null);
        return gson.fromJson(res,JsAPITicketResult.class);
    }
}
