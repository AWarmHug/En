package com.me.en.net.Api;

import com.me.en.entity.AlbumBean;
import com.me.en.entity.Base;
import com.me.en.entity.Lecture;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/2
 * 简介:首页
 */

public interface YixiApi {

    @GET("{type}")
    Observable<AlbumBean> getSelect(@Path("type") String type);

    @GET("{type}/detail/{id}")
    Observable<Base<Lecture>> getLectureDetal(@Path("type") String type, @Path("id") int id);


}
