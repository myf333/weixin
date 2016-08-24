package com.myf.weixin.util;

import javax.net.ssl.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by myf on 2016/8/23.
 */
public class WXSSLSocketFactory {
    public static SSLSocketFactory getSocketFactory(String certPath,String password) throws Exception{

        InputStream client_input = Files.newInputStream(Paths.get(certPath));//客户端证书
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(client_input, password.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, password.toCharArray());
            sslContext.init(keyManagerFactory.getKeyManagers(), new TrustManager[]{tm}, null);
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                client_input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
