package com.me.en.core.yixi.view;

import com.me.en.entity.Base;
import com.me.en.entity.Error;
import com.me.en.entity.Lecture;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/5
 * 简介:
 */

public interface LectureDetailView {

    void getLectureDetailSuccess(Lecture lecture);
    void getLectureDetailFail(Error e);

    void getLecturePlaySuccess(Base base);

}
