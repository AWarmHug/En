package com.me.en.core.yixi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.me.en.R;
import com.me.en.base.fragment.LazyFragment;
import com.me.en.core.yixi.adapter.AlbumDetailAdapter;
import com.me.en.core.yixi.presenter.SelectPresenter;
import com.me.en.entity.AlbumBean;
import com.me.en.entity.Error;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/3
 * 简介:
 */

public class AlbumFragment extends LazyFragment implements SelectView {
    private static final String TAG = "AlbumFragment";

    private SelectPresenter selectPresenter;


    private Toolbar tb_select;
    private ViewPager vp;


    public static AlbumFragment newInstance() {

        Bundle args = new Bundle();

        AlbumFragment fragment = new AlbumFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    protected int getLayout() {
        return R.layout.fragment_select;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        tb_select= (Toolbar) view.findViewById(R.id.tb_select);
        vp= (ViewPager) view.findViewById(R.id.vp);
        setUserVisibleHint(true);

    }

    @Override
    protected void doInVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void doFirstVisible(@Nullable Bundle savedInstanceState) {
        selectPresenter=new SelectPresenter(this);
        selectPresenter.getSelect();

    }

    @Override
    protected void doVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void getSelectSuccess(AlbumBean albumBean) {
        AlbumDetailAdapter adapter=new AlbumDetailAdapter(getFragmentManager(),albumBean.getData());
        vp.setAdapter(adapter);



    }

    @Override
    public void getSelectFail(Error e) {

    }

}
