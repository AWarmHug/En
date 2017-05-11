package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.me.en.R;
import com.me.en.base.fragment.LazyFragment;
import com.me.en.core.yixi.adapter.LectureTypeVpAdapter;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/9
 * 简介:
 */

public class LectureTypeFragment extends LazyFragment {

    private ViewPager vp;
    private TabLayout tl;



    public static LectureTypeFragment newInstance() {

        Bundle args = new Bundle();

        LectureTypeFragment fragment = new LectureTypeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_lecture_type;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        vp= (ViewPager) view.findViewById(R.id.vp);
        tl= (TabLayout) view.findViewById(R.id.tl);

    }

    @Override
    protected void doInVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void doFirstVisible(@Nullable Bundle savedInstanceState) {

        LectureTypeVpAdapter adapter=new LectureTypeVpAdapter(getChildFragmentManager());
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(3);
        tl.setupWithViewPager(vp);

    }

    @Override
    protected void doVisible(@Nullable Bundle savedInstanceState) {

    }


}
