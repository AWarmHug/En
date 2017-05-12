package com.me.en.widget.behavior;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.me.en.R;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/12
 * 简介:
 */

public class TBehavior extends CoordinatorLayout.Behavior<Toolbar> {
    private static final String TAG = "TBehavior";

    int y;

    public TBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {

        return dependency instanceof ViewPager;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Toolbar child, View dependency) {

        Log.d(TAG, "onDependentViewChanged: "+dependency.getTranslationY());


        return super.onDependentViewChanged(parent, child, dependency);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        Log.d(TAG, "onNestedScroll: "+dyConsumed);

    }



    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);


    }



    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }


}
