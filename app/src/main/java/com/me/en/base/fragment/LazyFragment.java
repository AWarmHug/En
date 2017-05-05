package com.me.en.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.me.en.App;


/**
 * 作者: 51hs_android
 * 时间: 2017/2/22
 * 简介:
 */

public abstract class LazyFragment extends GodFragment {




    /**
     * 判断是不是一次可见,
     */
    private boolean isFirst = true;

    /**
     * 标志inflater是否已经完成
     */
    private boolean isInflate;

    /**
     * 标志 是否已经可见
     */
    private boolean isVisible;


  private   Bundle mSavedFragmentState;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSavedFragmentState=savedInstanceState;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isInflate = true;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initPrepare(mSavedFragmentState);
    }

    /**
     * 这是一个实际操作方法
     */
    private synchronized void initPrepare(@Nullable Bundle savedInstanceState) {

        if (isInflate && isVisible) {
            if (isFirst) {
                doFirstVisible(savedInstanceState);
                isFirst = false;
            } else {
                doVisible(savedInstanceState);
            }
        } else {
            doInVisible(savedInstanceState);
        }
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isVisible = true;
            if (isFirst) {
                initPrepare(mSavedFragmentState);
            } else {
                initPrepare(mSavedFragmentState);
            }
        } else {
            isVisible = false;
            initPrepare(mSavedFragmentState);
        }
    }

    /**
     * 用户不可见时.
     */
    protected abstract void doInVisible(@Nullable Bundle savedInstanceState);

    /**
     * 第一次加载出来,我们可以进行数据加载
     * @param savedInstanceState
     */
    protected abstract void doFirstVisible(@Nullable Bundle savedInstanceState);

    /**
     * 用户可见时,但不是第一次可见,就是回到从其他页面回到当前页面时.
     */
    protected abstract void doVisible(@Nullable Bundle savedInstanceState);





    public App getApp() {
        return (App) getActivity().getApplication();
    }


}
