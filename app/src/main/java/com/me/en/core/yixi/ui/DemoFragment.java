package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.view.View;

import com.me.en.R;
import com.me.en.base.fragment.BaseFragment;

/**
 * Created by warm on 17/5/4.
 */

public class DemoFragment extends BaseFragment  {
    private static final String TAG = "AlbumDetailFragment";



    public static DemoFragment newInstance() {

        Bundle args = new Bundle();

        DemoFragment fragment = new DemoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_demo;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

}
