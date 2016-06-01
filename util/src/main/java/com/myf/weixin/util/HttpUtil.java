package com.myf.weixin.util;

import com.squareup.okhttp.*;

import javax.net.ssl.*;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * Created by myf on 2016/5/23.
 */
public class HttpUtil {
    private static OkHttpClient client = new OkHttpClient();
    static{
        try {
            TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            SSLContext e = SSLContext.getInstance("TLS");
            e.init(null, new TrustManager[]{tm}, null);
            client.setSslSocketFactory(e.getSocketFactory());
            client.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static String Get(String url,Map<String,String> params) throws Exception {
        if(params!=null && params.size()>0){
            url += "?";
            int i = 0;
            for (String param:
                    params.keySet()) {
                if (i == 0) {
                    url += String.format("%s=%s", param, params.get(param));
                } else {
                    url += String.format("&%s=%s", param, params.get(param));
                }
                i++;
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "text/json")
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("请求失败,code: " + response);
        return response.body().string();
    }

    public static String Post(String url,Map<String,String> params) throws Exception{
        FormEncodingBuilder builder = new FormEncodingBuilder();
        if(params != null&&params.size()>0)
        {
            for (String param:
                    params.keySet()) {
                builder.add(param,params.get(param));
            }
        }
        RequestBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "text/json")
                .post(formBody)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("请求失败,code: " + response);
        return response.body().string();
    }

    public static String postJson(String url,String jsonStr) throws Exception{
        RequestBody jsonBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "text/json")
                .post(jsonBody)
                .build();
        Response response = client.newCall(request).execute();
        if(!response.isSuccessful()) throw new IOException("请求失败,code: " + response);
        return response.body().string();
    }

    public static Response Download(String url,Map<String,String> params) throws Exception {
        if(params!=null && params.size()>0){
            url += "?";
            int i = 0;
            for (String param:
                    params.keySet()) {
                if (i == 0) {
                    url += String.format("%s=%s", param, params.get(param));
                } else {
                    url += String.format("&%s=%s", param, params.get(param));
                }
                i++;
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("请求失败,code: " + response);
        return response;
    }

    public static String UploadFile(String url,Map<String,String> params,String formData,String fileName,String filePath) throws Exception{
        MultipartBuilder  builder = new MultipartBuilder ().type(MultipartBuilder.FORM);
        File file = new File(filePath);
        builder.addFormDataPart(formData,fileName,RequestBody.create(MediaType.parse("application/octet-stream"), file));
        if(params != null&&params.size()>0)
        {
            for (String param:
                    params.keySet()) {
                builder.addFormDataPart(param,null, RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.get(param)));
            }
        }
        RequestBody fileBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "text/json")
                .post(fileBody)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("请求失败,code: " + response);
        return response.body().string();
    }
}
