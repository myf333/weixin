package com.myf.weixin.entity.weixin.message;

/**
 * Created by myf on 2016/5/20.
 */
public class SendLocationInfo {
    private String Location_X;
    private String Location_Y;
    private String Scale;//精度，可理解为精度或者比例尺、越精细的话 scale越高
    private String Label;//地理位置的字符串信息
    private String Poiname;//朋友圈POI的名字，可能为空

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getPoiname() {
        return Poiname;
    }

    public void setPoiname(String poiname) {
        Poiname = poiname;
    }
}
