package com.myf.weixin.util;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by myf on 2016/5/13.
 */
public class CheckSignature {
    public static boolean Check(String signature, String timestamp, String nonce, String token)
    {
        return signature.equals(GetSignature(timestamp, nonce, token));
    }

    public static String GetSignature(String timestamp, String nonce, String token)
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add(token);
        list.add(timestamp);
        list.add(nonce);
        Collections.sort(list);

        String arrString = StringUtils.join(list.toArray());
        try {
            String sha1Arr = EncryptUtil.Encrypt(arrString, "SHA1", "UTF-8");
            return sha1Arr;
        }catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
            return "";
        }
    }

    /**
     * 获取卡券签名
     * **/
    public static String GetCardSignature(String code,String timestamp, String card_id,String nonce_str, String api_ticket,String openId,String balance)
    {
        ArrayList<String> list = new ArrayList<String>();
        if(code!=null)list.add(code);
        list.add(timestamp);
        list.add(card_id);
        list.add(nonce_str);
        list.add(api_ticket);
        if(openId!=null)list.add(openId);
        if(balance!=null)list.add(balance);
        Collections.sort(list);

        String arrString = StringUtils.join(list.toArray());
        try {
            String sha1Arr = EncryptUtil.Encrypt(arrString, "SHA1", "UTF-8");
            return sha1Arr;
        }catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
            return "";
        }
    }

    /**
     *  获取jsapi签名
     * **/
    public static String GetJsApiSignature(String jsapi_ticket,String nonceStr, String timestamp,String url)
    {
        String arrString = MessageFormat.format("jsapi_ticket={0}&noncestr={1}&timestamp={2}&url={3}", jsapi_ticket, nonceStr, timestamp, url);
        try {
            String sha1Arr = EncryptUtil.Encrypt(arrString, "SHA1", "UTF-8");
            return sha1Arr;
        }catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
            return "";
        }
    }
}
