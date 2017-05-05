package com.me.en.core.yixi.model;

import android.util.Log;

import com.me.en.base.Listener;
import com.me.en.entity.Base;
import com.me.en.entity.Error;
import com.me.en.entity.Lecture;
import com.me.en.entity.Video;
import com.me.en.net.Api.YixiApi;
import com.me.en.net.RetrofitHelper;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/5
 * 简介:
 */

public class LectureModelImpl implements LectureModel {

    @Override
    public void getLecture(int id, final Listener<Lecture> listener)  {
        RetrofitHelper.getApi(YixiApi.class).getLectureDetal("lecture",id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Base<Lecture>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Base<Lecture> lectureBase) {
                        listener.success(lectureBase.getData());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        listener.fail(new Error(-1,e.getMessage()));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getLecturePlay(int id, final String playId , Listener<Video> listener) {

        RetrofitHelper.getApi(YixiApi.class).getLecturePlayed(id)
                .flatMap(new Function<Base, ObservableSource<Video>>() {
                    @Override
                    public ObservableSource<Video> apply(@NonNull Base base) throws Exception {
                        return base.getMsg().equals("success")?RetrofitHelper.getApi(YixiApi.class).getPlay("http://api.yixi.tv/youku.php",playId):null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Video>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Video video) {
                        Log.d("okhttp", "onNext: "+video.getSid());

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
