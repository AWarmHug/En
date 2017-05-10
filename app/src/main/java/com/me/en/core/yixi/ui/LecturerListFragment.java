package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.me.en.R;
import com.me.en.base.fragment.LazyFragment;
import com.me.en.core.yixi.adapter.LecturerRvAdapter;
import com.me.en.entity.Base;
import com.me.en.entity.Lecturer;
import com.me.en.net.RetrofitHelper;
import com.me.en.net.api.YixiApi;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/10
 * 简介:
 */

public class LecturerListFragment extends LazyFragment {

    private RecyclerView rv;

    public static LecturerListFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("id", id);
        LecturerListFragment fragment = new LecturerListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void doInVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void doFirstVisible(@Nullable Bundle savedInstanceState) {

        RetrofitHelper.getApi(YixiApi.class).getLecturers(getArguments().getInt("id",0))
                .map(new Function<Base<List<Lecturer>>, List<Lecturer>>() {
                    @Override
                    public List<Lecturer> apply(@NonNull Base<List<Lecturer>> listBase) throws Exception {
                        return listBase.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Lecturer>>() {
                    @Override
                    public void accept(@NonNull List<Lecturer> lecturers) throws Exception {
                        LecturerRvAdapter adapter=new LecturerRvAdapter(lecturers);
                        rv.setAdapter(adapter);
                        rv.setLayoutManager(new GridLayoutManager(getContext(),3));


                    }
                });

    }

    @Override
    protected void doVisible(@Nullable Bundle savedInstanceState) {


    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_recy;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        rv= (RecyclerView) view.findViewById(R.id.rv);

    }
}
