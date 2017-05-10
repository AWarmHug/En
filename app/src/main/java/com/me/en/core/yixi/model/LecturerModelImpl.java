package com.me.en.core.yixi.model;

import com.me.en.base.Listener;
import com.me.en.entity.Base;
import com.me.en.entity.Category;
import com.me.en.entity.Lecturer;
import com.me.en.net.RetrofitHelper;
import com.me.en.net.api.YixiApi;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Path;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/10
 * 简介:
 */

public class LecturerModelImpl implements LecturerModel {


    @Override
    public void getCategory(final Listener<List<Category>> listener) {
        RetrofitHelper.getApi(YixiApi.class).getCategory()
                .filter(new Predicate<Base<List<Category>>>() {
                    @Override
                    public boolean test(@NonNull Base<List<Category>> listBase) throws Exception {
                        return listBase.getRes()==0;
                    }
                })
                .map(new Function<Base<List<Category>>, List<Category>>() {
                    @Override
                    public List<Category> apply(@NonNull Base<List<Category>> listBase) throws Exception {
                        return listBase.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Category>>() {
                    @Override
                    public void accept(@NonNull List<Category> categories) throws Exception {
                        listener.success(categories);

                    }
                });
    }

    @Override
    public void getLecturers(@Path("id") int id, final Listener<List<Lecturer>> listener) {
        RetrofitHelper.getApi(YixiApi.class).getLecturers(id).map(new Function<Base<List<Lecturer>>, List<Lecturer>>() {
            @Override
            public List<Lecturer> apply(@NonNull Base<List<Lecturer>> listBase) throws Exception {
                return listBase.getRes()==0?listBase.getData():null;
            }
        }) .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Lecturer>>() {
                    @Override
                    public void accept(@NonNull List<Lecturer> lecturers) throws Exception {
                        listener.success(lecturers);

                    }
                });




    }
}
