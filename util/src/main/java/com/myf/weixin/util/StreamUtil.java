package com.myf.weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by myf on 2016/5/18.
 */
public class StreamUtil {
    public static final int BUFFER_SIZE = 4096;

    public static String copyStreamToString(InputStream stream,Charset charset) throws IOException{
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[BUFFER_SIZE];
        InputStreamReader reader = new InputStreamReader(stream,charset);
        int bytesRead;
        while ((bytesRead=reader.read(buffer))!=-1){
            sb.append(buffer,0,bytesRead);
        }
        return sb.toString();
    }
}
