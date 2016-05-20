package com.myf.weixin.entity.weixin.message;

/**
 * Created by myf on 2016/5/20.
 */
public class ScanCodeInfo {
    private String ScanType;
    private String ScanResult;

    public String getScanType() {
        return ScanType;
    }

    public String getScanResult() {
        return ScanResult;
    }

    public void setScanResult(String scanResult) {
        ScanResult = scanResult;
    }

    public void setScanType(String scanType) {
        ScanType = scanType;
    }
}
