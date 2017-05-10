package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.me.en.R;
import com.me.en.base.fragment.BaseFragment;
import com.me.en.core.yixi.adapter.MoreAdapter;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/9
 * 简介:
 */

public class MoreFragment extends BaseFragment{
    private static final String TAG = "MoreFragment";

    private ViewPager vp;


    public static MoreFragment newInstance() {

        Bundle args = new Bundle();

        MoreFragment fragment = new MoreFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_more;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        vp= (ViewPager) view.findViewById(R.id.vp);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
        MoreAdapter adapter=new MoreAdapter(getChildFragmentManager());
        vp.setAdapter(adapter);
    }
}
