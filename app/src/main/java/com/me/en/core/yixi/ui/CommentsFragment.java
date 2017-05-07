package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.me.en.R;
import com.me.en.base.fragment.LazyFragment;

/**
 * Created by warm on 17/5/7.
 */

public class CommentsFragment extends LazyFragment{


    public static CommentsFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("id",id);
        CommentsFragment fragment = new CommentsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void doInVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void doFirstVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void doVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_comments;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}
