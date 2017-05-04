package com.me.en.base;

import com.me.en.entity.Error;

/**
 * 作者: 51hs_android
 * 时间: 2017/2/11
 * 简介:
 */

public interface Listener<T> {
    void success(T t);
    void fail(Error e);

}
