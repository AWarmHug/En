package com.me.en.widget.envideoplayer.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.VideoView;

/**
 * Created by warm on 17/5/6.
 */

public class EnVideoView extends VideoView {
    private static final String TAG = "EnVideoView";

    private GestureDetector mGesture;

    private OnEnVideoViewGester onEnVideoViewGester;

    public void setOnEnVideoViewGester(OnEnVideoViewGester onEnVideoViewGester) {
        this.onEnVideoViewGester = onEnVideoViewGester;
    }

    public EnVideoView(Context context) {
        this(context,null);
    }

    public EnVideoView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public EnVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mGesture=new GestureDetector(getContext(),new MyGester());

    }

    /**
     * 当前的百分比
     * @return
     */
    public int getCurrentPercentage(){
        return getCurrentPosition()*100/getDuration();
    }


    private MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener=new MediaPlayer.OnBufferingUpdateListener() {
        @Override
        public void onBufferingUpdate(MediaPlayer mp, int percent) {

        }
    };


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        mGesture.onTouchEvent(ev);//手势添加按压的事件

        return true;
    }

    /**
     * 定义手势监听的内部类继承 GestureDetector.SimpleOnGestureListener
     * 重写onScroll滑动监听的方法，左右滑动值监听X轴
     */
    class MyGester extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            onEnVideoViewGester.onSingleTapUp();

            return super.onSingleTapUp(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

                onEnVideoViewGester.onScroll(distanceX,distanceY);

            return super.onScroll(e1, e2, distanceX, distanceY);
        }
    }

    interface OnEnVideoViewGester{
        void onSingleTapUp();
        void onScroll(float distanceX, float distanceY);

    }

}
