package com.me.en.core.yixi.model;

import android.util.Log;

import com.me.en.base.Listener;
import com.me.en.entity.Error;
import com.me.en.entity.AlbumBean;
import com.me.en.net.api.YixiApi;
import com.me.en.net.RetrofitHelper;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/3
 * 简介:
 */

public class AlbumModelImpl implements AlbumModel {
    private static final String TAG = "SelectModelImpl";

    @Override
    public void getSelect(final Listener<AlbumBean> listener) {

        RetrofitHelper.getApi(YixiApi.class).getSelect("album")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AlbumBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull AlbumBean albumBean) {
                        Log.d(TAG, "onNext: " + Thread.currentThread().getName());
                        listener.success(albumBean);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                        listener.fail(new Error(0, e.getMessage()));

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onNext: " + Thread.currentThread().getName());


                    }
                });
    }
}
