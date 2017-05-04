package com.me.en.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 作者: 51hs_android
 * 时间: 2017/2/8
 * 简介:重写Viewpager解决点击tab去除滑动动画效果的问题
 * 禁止左右滑动
 *
 */
public class NoScrollViewPager extends ViewPager {

    public NoScrollViewPager(Context context) {

        super(context);
    }


    public NoScrollViewPager(Context context, AttributeSet attrs) {

        super(context, attrs);
    }


    //解决点击tab去除滑动动画效果的问题

    @Override
    public void scrollTo(int x, int y) {

        super.scrollTo(x, y);
    }


    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {

        super.setCurrentItem(item, smoothScroll);
    }


    @Override
    public void setCurrentItem(int item) {

        super.setCurrentItem(item, false);
    }




    //禁止左右滑动
//
//
//    //拦截 TouchEvent     返回false 拦截
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent event) {
//        return false;
//    }
//
//    //处理 TouchEvent
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        // TODO Auto-generated method stub
////        return super.onTouchEvent(arg0);
//        return false;
//    }
//
//
//
//    //因为这个执行的顺序是  父布局先得到 action_down的事件
//    /**
//     * onInterceptTouchEvent(MotionEvent ev)方法，这个方法只有ViewGroup类有
//     * 如LinearLayout，RelativeLayout等    可以包含子View的容器的
//     *
//     * 用来分发 TouchEvent
//     * 此方法    返回true    就交给本 View的 onTouchEvent处理
//     * 此方法    返回false   就交给本View的 onInterceptTouchEvent 处理
//     */
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        //让父类不拦截触摸事件就可以了。
//        this.getParent().requestDisallowInterceptTouchEvent(false);
//        return super.dispatchTouchEvent(ev);
//
//    }


}
