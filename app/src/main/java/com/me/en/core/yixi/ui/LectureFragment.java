package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.me.en.R;
import com.me.en.base.fragment.BaseFragment;
import com.me.en.core.yixi.adapter.LectureVpAdapter;

/**
 * Created by warm on 17/5/7.
 */

public class LectureFragment extends BaseFragment {

    private ViewPager vp;

    private int id;

    public static LectureFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("id",id);
        LectureFragment fragment = new LectureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_lecture;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        vp= (ViewPager) view.findViewById(R.id.vp);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        id=getArguments().getInt("id");
        LectureVpAdapter adapter=new LectureVpAdapter(getChildFragmentManager(),id);
        vp.setAdapter(adapter);

    }

}
