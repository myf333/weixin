package com.myf.weixin.util;

import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by myf on 2016/5/24.
 */
public class FileUtil {
    /*
    *  保存微信媒体文件
    * */
    public static String saveWXMediaFile(Response response,String savePath) throws IOException {
        InputStream in = response.body().byteStream();
        byte[] buffer = new byte[2046];
        String contentDisposition = response.headers().get("Content-disposition");
        if(null == contentDisposition || "".equals(contentDisposition)){
            throw new IOException(String.format("获取媒体文件失败:%s",response.body().toString()));
        }
        String[] strs = contentDisposition.split(";|=");
        String fileName = strs[2].replace("\"","");
        savePath = savePath+File.separator+ DateFormat.getDateInstance().format(new Date());
        File dir = new File(savePath);
        if(!dir.exists()){
            if(!dir.mkdir()) throw new IOException("创建目录失败");
        }
        File file = new File(dir,fileName);
        FileOutputStream out = new FileOutputStream(file);
        int len = 0;
        while ((len = in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        out.flush();
        out.close();
        return  file.getPath();
    }
}
