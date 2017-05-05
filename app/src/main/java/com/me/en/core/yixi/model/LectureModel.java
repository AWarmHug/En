package com.me.en.core.yixi.model;

import com.me.en.base.Listener;
import com.me.en.entity.Lecture;
import com.me.en.entity.Video;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/5
 * 简介:
 */

public interface LectureModel {

    void getLecture(int id,Listener<Lecture> listener);

    void getLecturePlay(int id, String playId,Listener<Video> listener);


}
