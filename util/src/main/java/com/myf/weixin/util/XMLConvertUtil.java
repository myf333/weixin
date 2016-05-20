package com.myf.weixin.util;

import com.thoughtworks.xstream.XStream;

/**
 * Created by myf on 2016/5/18.
 */
public class XMLConvertUtil {

    @SuppressWarnings("unchecked")
    public static <T> T convertToObject(Class<T> clazz,String xml){
        //XStream xstream = new XStream();
        XStream xstream = XStreamUtil.createXstream();
        xstream.alias("xml", clazz);
        xstream.autodetectAnnotations(true);
        return (T) xstream.fromXML(xml);
    }

    public static <T> String toXML(Class<T> clazz,T instance){
        //XStream xstream = new XStream();
        XStream xstream = XStreamUtil.createXstream();
        xstream.alias("xml", clazz);
        xstream.autodetectAnnotations(true);
        return xstream.toXML(instance);
    }
}
