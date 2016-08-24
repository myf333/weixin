package com.myf.weixin.util;

import com.squareup.okhttp.*;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import java.io.IOException;

/**
 * Created by myf on 2016/8/23.
 */
public class OKHttpUtil {

    public static String postXml(String url,String xml,String certPath,String pwd) throws Exception{
        RequestBody xmlBody = RequestBody.create(MediaType.parse("application/xml; charset=utf-8"),xml);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "text/xml")
                .post(xmlBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        client.setSslSocketFactory(WXSSLSocketFactory.getSocketFactory(certPath,pwd));
//        client.setHostnameVerifier(new HostnameVerifier() {
//            @Override
//            public boolean verify(String hostname, SSLSession session) {
//                return true;
//            }
//        });
        client.setHostnameVerifier((String,SSLSession)->true);
        Response response = client.newCall(request).execute();
        if(!response.isSuccessful()) throw new IOException("请求失败,code: " + response);
        return response.body().string();
    }
}
