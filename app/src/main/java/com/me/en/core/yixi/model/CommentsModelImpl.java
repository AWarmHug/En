package com.me.en.core.yixi.model;

import com.me.en.base.Listener;
import com.me.en.entity.Base;
import com.me.en.entity.Comment;
import com.me.en.net.RetrofitHelper;
import com.me.en.net.api.YixiApi;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by warm on 17/5/8.
 */

public class CommentsModelImpl implements CommentsModel {

    @Override
    public void getComments(int id, int page, final Listener<List<Comment>> listener) {
        RetrofitHelper.getApi(YixiApi.class).getComments("lecture",id,page)
                .map(new Function<Base<List<Comment>>, List<Comment>>() {
                    @Override
                    public List<Comment> apply(@NonNull Base<List<Comment>> listBase) throws Exception {
                        return listBase.getRes()==0?listBase.getData():null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Comment>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Comment> comments) {
                        listener.success(comments);
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
