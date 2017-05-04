package com.me.en.core.openeye.view;

import com.me.en.entity.Error;
import com.me.en.entity.SelectBean;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/3
 * 简介:
 */

public interface SelectView {

    void getSelectSuccess(SelectBean selectBean);
    void getSelectFail(Error e);


}
