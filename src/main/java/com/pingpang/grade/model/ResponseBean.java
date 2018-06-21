package com.pingpang.grade.model;

public class ResponseBean<T> {

    public static String ErrorTokenCode = "88880001";
    public static String ErrorTokenInfo = "无效用户，请重新登录";

    public static String ErrorDataCode = "88880002";
    public static String ErrorDataInfo = "上传数据错误";

    private String errorCode = "00000000";
    private String errorInfo = "请求成功";
    private T data;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
