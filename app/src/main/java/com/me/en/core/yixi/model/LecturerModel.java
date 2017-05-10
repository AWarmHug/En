package com.me.en.core.yixi.model;

import com.me.en.base.Listener;
import com.me.en.entity.Category;
import com.me.en.entity.Lecturer;

import java.util.List;

import retrofit2.http.Path;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/10
 * 简介:
 */

public interface LecturerModel {

    void getCategory(Listener<List<Category>> listener);

    void  getLecturers(@Path("id") int id, Listener<List<Lecturer>> listener);

}
