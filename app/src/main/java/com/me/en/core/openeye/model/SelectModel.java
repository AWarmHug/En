package com.me.en.core.openeye.model;

import android.util.Log;

import com.me.en.base.Listener;
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

public interface SelectModel {

     void getSelect(Listener<SelectBean> listener);
}
