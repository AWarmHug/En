package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.me.en.R;
import com.me.en.base.fragment.LazyFragment;
import com.me.en.core.yixi.adapter.LecturerVpAdapter;
import com.me.en.entity.Base;
import com.me.en.entity.Category;
import com.me.en.net.RetrofitHelper;
import com.me.en.net.api.YixiApi;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/9
 * 简介:
 */

public class LecturerTypeFragment extends LazyFragment {
    private Toolbar tb;
    private TabLayout tl;
    private ViewPager vp;


    public static LecturerTypeFragment newInstance() {

        Bundle args = new Bundle();

        LecturerTypeFragment fragment = new LecturerTypeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_lecture_type;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        tb= (Toolbar) view.findViewById(R.id.tb);
        tb.setTitle("全部讲者");
        tl= (TabLayout) view.findViewById(R.id.tl);
        vp= (ViewPager) view.findViewById(R.id.vp);

    }

    @Override
    protected void doInVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void doFirstVisible(@Nullable Bundle savedInstanceState) {
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
                        LecturerVpAdapter adapter =new LecturerVpAdapter(getChildFragmentManager(),categories);
                        vp.setAdapter(adapter);
                        tl.setupWithViewPager(vp);

                    }
                });


    }

    @Override
    protected void doVisible(@Nullable Bundle savedInstanceState) {

    }


}
