package com.me.en.base.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.me.en.R;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/3
 * 简介:
 */

public abstract class GodFragment extends Fragment implements View.OnTouchListener {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        view.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.white));
        view.setOnTouchListener(this);
        initView(view,savedInstanceState);
//        view.setBackground(getActivity().getWindow().getDecorView().getBackground());
        return view;
    }

    protected abstract int getLayout();


    protected abstract void initView(View view, Bundle savedInstanceState);

    /**
     * @return statuBar高度
     */
    public int getBarHeight() {

        /**
         * 获取状态栏高度——方法1
         * */
        int statusBarHeight = 0;
        if (Build.VERSION.SDK_INT >= 21) {
//获取status_bar_height资源的ID
            int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                //根据资源ID获取响应的尺寸值
                statusBarHeight = getResources().getDimensionPixelSize(resourceId);
            }
        }
        return statusBarHeight;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v == getView()) {
            return true;
        }
        return false;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter){
            return AnimationUtils.loadAnimation(getContext(), R.anim.v_fragment_enter);
        }
        return AnimationUtils.loadAnimation(getContext(), R.anim.v_fragment_exit);
    }



}
