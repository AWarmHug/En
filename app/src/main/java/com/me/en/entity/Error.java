package com.me.en.entity;

/**
 * 作者: 51hs_android
 * 时间: 2017/2/27
 * 简介:
 */

public class Error {
    private int status;
    private String message;
    private String methodName;


    public Error(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Error(int status, String message, String methodName) {
        this.status = status;
        this.message = message;
        this.methodName = methodName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getMessage() {
        return message;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        return "BaseError{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", methodName='" + methodName + '\'' +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
