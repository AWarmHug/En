package com.me.en.net.api;

import com.me.en.entity.AlbumBean;
import com.me.en.entity.Base;
import com.me.en.entity.Comment;
import com.me.en.entity.Lecture;
import com.me.en.entity.Video;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

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

    @FormUrlEncoded
    @POST("stat/lectureplayed")
    Observable<Base> getLecturePlayed(@Field("id") int id);

    @GET
    Observable<Video> getPlay(@Url String url, @Query("id") String id);

    @GET("{type}/comments/{id}/page/{page}")
    Observable<Base<List<Comment>>> getComments(@Path("type") String type,@Path("id") int id,@Path("page") int page);

    @GET("{type}/comments/{id}/page/{page}")
    Flowable<Base<List<Comment>>> getComments2(@Path("type") String type,@Path("id") int id,@Path("page") int page);




}
