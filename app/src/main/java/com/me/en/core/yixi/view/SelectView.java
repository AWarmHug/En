package com.me.en.core.yixi.view;

import com.me.en.entity.Error;
import com.me.en.entity.AlbumBean;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/3
 * 简介:
 */

public interface SelectView {

    void getSelectSuccess(AlbumBean albumBean);
    void getSelectFail(Error e);


}
