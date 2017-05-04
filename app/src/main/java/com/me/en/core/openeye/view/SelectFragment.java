package com.me.en.core.openeye.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.me.en.R;
import com.me.en.base.fragment.LazyFragment;
import com.me.en.core.openeye.adapter.SelectRecyAdapter;
import com.me.en.core.openeye.presenter.SelectPresenter;
import com.me.en.entity.Error;
import com.me.en.entity.SelectBean;
import com.me.en.widget.recycleview.EnRecycleView;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/3
 * 简介:
 */

public class SelectFragment extends LazyFragment implements SelectView {
    private static final String TAG = "SelectFragment";

    private SelectPresenter selectPresenter;


    private Toolbar tb_select;
    private EnRecycleView rv_select;


    public static SelectFragment newInstance() {

        Bundle args = new Bundle();

        SelectFragment fragment = new SelectFragment();
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
        rv_select= (EnRecycleView) view.findViewById(R.id.rv_select);

    }

    @Override
    protected void doInVisible() {

    }

    @Override
    protected void doFirstVisible() {
        selectPresenter=new SelectPresenter(this);
        selectPresenter.getSelect();

    }

    @Override
    protected void doVisible() {

    }

    @Override
    public void getSelectSuccess(SelectBean selectBean) {
        SelectRecyAdapter selectRecyAdapter=new SelectRecyAdapter(selectBean.getItemList());
        rv_select.setAdapter(selectRecyAdapter);


    }

    @Override
    public void getSelectFail(Error e) {

    }

}
