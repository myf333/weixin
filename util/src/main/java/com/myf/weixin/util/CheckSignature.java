package com.myf.weixin.util;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
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
}
