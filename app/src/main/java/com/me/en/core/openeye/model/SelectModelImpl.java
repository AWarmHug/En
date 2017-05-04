package com.me.en.core.openeye.model;

import android.util.Log;

import com.me.en.base.Listener;
import com.me.en.entity.Error;
import com.me.en.entity.SelectBean;
import com.me.en.net.Api.SelectedApi;
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

public class SelectModelImpl implements SelectModel {
    private static final String TAG = "SelectModelImpl";

    @Override
    public void getSelect(final Listener<SelectBean> listener) {

        RetrofitHelper.getApi(SelectedApi.class).getSelect("selected")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SelectBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull SelectBean selectBean) {
                        Log.d(TAG, "onNext: "+Thread.currentThread().getName());
                        listener.success(selectBean);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        listener.fail(new Error(0,e.getMessage()));

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onNext: "+Thread.currentThread().getName());



                    }
                });
    }
}
