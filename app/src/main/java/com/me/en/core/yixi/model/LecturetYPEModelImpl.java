package com.me.en.core.yixi.model;

import android.util.Log;

import com.me.en.base.Listener;
import com.me.en.entity.Base;
import com.me.en.entity.Lecture;
import com.me.en.entity.LecturesByDate;
import com.me.en.net.RetrofitHelper;
import com.me.en.net.api.YixiApi;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/9
 * 简介:
 */

public class LectureTypeModelImpl implements LectureTypeModel {


    @Override
    public void getLectureByDate(String type, int page, final Listener<List<Lecture>> listener) {
        Observer<List<Lecture>> observer = new Observer<List<Lecture>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<Lecture> lectures) {
                listener.success(lectures);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


        if (type.equals("date")) {
            RetrofitHelper.getApi(YixiApi.class).getLectureByDate()
                    .map(new Function<Base<List<LecturesByDate>>, List<Lecture>>() {
                        @Override
                        public List<Lecture> apply(@NonNull Base<List<LecturesByDate>> listBase) throws Exception {
                            return getAllLectures(listBase.getData());
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);


        } else {

            RetrofitHelper.getApi(YixiApi.class).getLectureByType(type, page)
                    .map(new Function<Base<List<Lecture>>, List<Lecture>>() {
                        @Override
                        public List<Lecture> apply(@NonNull Base<List<Lecture>> listBase) throws Exception {
                            return listBase.getData();
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        }
    }

    private List<Lecture> getAllLectures(List<LecturesByDate> lecturesByDates){
        List<Lecture> lectures=new ArrayList<>();
        Log.d("Tag--", "getAllLectures: ");
        for (LecturesByDate lecturesByDate:lecturesByDates) {
            lectures.addAll(lecturesByDate.getLectures());
        }
        return lectures;


    }


}
