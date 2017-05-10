package com.me.en.core.yixi.model;

import com.me.en.base.Listener;
import com.me.en.entity.Base;
import com.me.en.entity.Lecture;
import com.me.en.entity.LecturesByDate;
import com.me.en.net.RetrofitHelper;
import com.me.en.net.api.YixiApi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    private static final String TAG = "LectureTypeModelImpl";

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

            Observable.timer(300, TimeUnit.MILLISECONDS).flatMap(new Function<Long, ObservableSource<Base<List<LecturesByDate>>>>() {
                @Override
                public ObservableSource<Base<List<LecturesByDate>>> apply(@NonNull Long aLong) throws Exception {
                    return RetrofitHelper.getApi(YixiApi.class).getLectureByDate();
                }
            }).map(new Function<Base<List<LecturesByDate>>, List<Lecture>>() {
                @Override
                public List<Lecture> apply(@NonNull Base<List<LecturesByDate>> listBase) throws Exception {
                    return getAllLectures(listBase.getData());
                }
            }).subscribeOn(Schedulers.io())
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

    private List<Lecture> getAllLectures(List<LecturesByDate> lecturesByDates) {
        List<Lecture> lectures = new ArrayList<>();
        for (LecturesByDate lecturesByDate : lecturesByDates) {
            lectures.addAll(lecturesByDate.getLectures());
        }
        return lectures;


    }


}
