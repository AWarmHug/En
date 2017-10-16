package com.me.en.base.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
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
    private static final String TAG = "GodFragment";


    private Animation in,out;
    private GestureDetector mGestureDetector;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       in= AnimationUtils.loadAnimation(getContext(), R.anim.v_fragment_enter);
       out= AnimationUtils.loadAnimation(getContext(), R.anim.v_fragment_exit);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        view.setOnTouchListener(this);
        initView(view,savedInstanceState);
        return view;
    }

    private void slideFinish(View view) {

        mGestureDetector=new GestureDetector(getContext(),new GestureListener());

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

    /**
     * 手势监听
     */
    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final String TAG = "GestureListener";
        private float x;


        @Override
        public void onShowPress(MotionEvent e) {
            super.onShowPress(e);
            Log.d(TAG, "onShowPress: ");

        }

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d(TAG, "onDown: ");
            x=0;
            return super.onDown(e);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.d(TAG, "onSingleTapUp: ");
            return super.onSingleTapUp(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

            Log.d(TAG, "onScroll: distanceX="+distanceX);
            Log.d(TAG, "onScroll: distanceY="+distanceY);
            x+=distanceX;


            Log.d(TAG, "onScroll: "+x);


            return super.onScroll(e1, e2, distanceX, distanceY);
        }


        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d(TAG, "onFling: ");

            return super.onFling(e1, e2, velocityX, velocityY);
        }


        @Override
        public boolean onContextClick(MotionEvent e) {
            Log.d(TAG, "onContextClick: ");
            return super.onContextClick(e);
        }
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
            return in;
        }
        return out;
    }

    /**
     *
     * @param pxValue
     * @return
     */
    public int px2dp( float pxValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     *
     * @param dipValue
     * @return
     */
    public int dp2px( float dipValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     *
     * @param pxValue
     * @return
     */
    public  int px2sp( float pxValue) {
        final float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     *
     * @param spValue
     * @return
     */
    public int sp2px( float spValue) {
        final float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }




}
