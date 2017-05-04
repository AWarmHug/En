package com.me.en.widget.recycleview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * 作者: 51hs_android
 * 时间: 2017/4/11
 * 简介:
 */

public class EnRecycleView extends RecyclerView {
    private static final String TAG = "MyRecycleView";

    private LoadMore loadMore;

    private float startY;
    private float startX;
    // 记录viewPager是否拖拽的标记
    private boolean mIsVpDragger;

    /**
     * 是否加载结束，在UI界面控制，
     */
    private boolean loadF=true;
    private LinearLayoutManager linearLayoutManager;



    public void setLoadMore(LoadMore loadMore) {
        this.loadMore = loadMore;
    }

    public EnRecycleView(Context context) {
        this(context, null);
    }

    public EnRecycleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EnRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setLayoutManager(new LinearLayoutManager(getContext()));
        addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    public void setLoadF(boolean loadF) {
        this.loadF = loadF;
    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        super.setLayoutManager(layout);
        if (layout instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layout;
        }
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);

        if (linearLayoutManager != null) {

            int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            int totalItemCount = linearLayoutManager.getItemCount();

            Log.d(TAG, "onScrolled: ");
            if (loadMore != null && lastVisibleItem >= totalItemCount - 4 && loadF) {
                loadMore.load();
                loadF = false;
            }
        }

    }


    public interface LoadMore {
        void load();

    }


//    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // 记录手指按下的位置
                startY = ev.getY();
                startX = ev.getX();
                // 初始化标记
//                mIsVpDragger = false;
                break;
            case MotionEvent.ACTION_MOVE:
                // 如果横向的RecycleView正在拖拽中，那么不拦截它的事件，直接return false；
//                if (mIsVpDragger) {
//                    return false;
//                }
                // 获取当前手指位置
                float endY = ev.getY();
                float endX = ev.getX();
                float distanceX = Math.abs(endX - startX);
                float distanceY = Math.abs(endY - startY);
                // 如果X轴位移大于Y轴位移，那么将事件交给横向的RecycleView处理。

                if (distanceX >= distanceY) {
//                    mIsVpDragger = true;
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:                // 初始化标记
//                mIsVpDragger = false;
                break;
        }
        // 如果是Y轴位移大于X轴，事件交给自己处理。
        return super.onInterceptTouchEvent(ev);
    }

}
