package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.me.en.R;
import com.me.en.base.fragment.LazyFragment;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/9
 * 简介:
 */

public class LecturerFragment extends LazyFragment {



    public static LecturerFragment newInstance() {

        Bundle args = new Bundle();

        LecturerFragment fragment = new LecturerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_lecturer_list;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void doInVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void doFirstVisible(@Nullable Bundle savedInstanceState) {
        Toast.makeText(getContext(), "这是演讲者界面", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void doVisible(@Nullable Bundle savedInstanceState) {

    }


}
