package com.myf.weixin.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by myf on 2016/5/6.
 */
public class EncryptUtil {
    /**
     *
     * @param inStr
     * @param algorithm exp:MD5,SHA
     * @param charset
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String Encrypt(String inStr,String algorithm,String charset) throws NoSuchAlgorithmException,UnsupportedEncodingException{
        StringBuilder sb = new StringBuilder();
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] digestBytes;
        if(charset == null || "".equals(charset)){
            digestBytes = digest.digest(inStr.getBytes());
        }else{
            digestBytes = digest.digest(inStr.getBytes(charset));
        }
        for(byte b:digestBytes){
            int val = b & 0xff;
            if(val <16) sb.append("0");
            sb.append(Integer.toHexString(val));
        }
        return sb.toString();
    }
}
