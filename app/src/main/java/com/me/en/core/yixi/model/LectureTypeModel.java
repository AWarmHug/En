package com.me.en.core.yixi.model;

import com.me.en.base.Listener;
import com.me.en.entity.Lecture;
import com.me.en.entity.LecturesByDate;

import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/9
 * 简介:
 */

public interface LectureTypeModel {

    void getLectureByDate(String type,int page,Listener<List<Lecture>> listener);

}
