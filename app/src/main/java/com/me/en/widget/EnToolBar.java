package com.me.en.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingChild;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/12
 * 简介:
 */

public class EnToolBar extends Toolbar implements NestedScrollingChild{
    private static final String TAG = "EnToolBar";

    public EnToolBar(Context context) {
        this(context,null);
    }

    public EnToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public EnToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        Log.d(TAG, "onNestedScroll: ");

    }
}
