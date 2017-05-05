package com.me.en.net.Api;

import com.me.en.entity.AlbumBean;

import io.reactivex.Observable;
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


}
