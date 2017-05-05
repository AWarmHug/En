package com.me.en.entity;

import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/5
 * 简介:
 */

public class Base<T> {

    private int res;

    private T data;



    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
