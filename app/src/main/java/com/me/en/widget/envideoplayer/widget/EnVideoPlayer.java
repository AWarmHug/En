package com.me.en.widget.envideoplayer.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

import com.me.en.R;
import com.me.en.widget.envideoplayer.state.PlayState;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by warm on 17/5/6.
 */

public class EnVideoPlayer extends RelativeLayout implements EnPlayController.PlayControl,EnVideoView.OnEnVideoViewGester {
    private static final String TAG = "EnVideoPlayer";


    private EnVideoView evv;

    private EnTitleBar etb;

    private EnPlayController epc;

    private Timer mTimer;
    private TimerTask mTimerTask;

    private final int MSG_UPDATE = -1001;

    private int playState;

    private int fullState;

    private int seekSpeed=15;


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case PlayState.PREPARE:
                    etb.setTitle("这是标题");
                    etb.setTotalTime(evv.getDuration());
                case MSG_UPDATE:
                    epc.updataProgress(evv.getCurrentPosition(), evv.getCurrentPercentage());

                    break;
            }

        }
    };


    public EnVideoPlayer(Context context) {
        this(context, null);
    }

    public EnVideoPlayer(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EnVideoPlayer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context, attrs, defStyle);
    }

    private void initView(Context context, AttributeSet attrs, int defStyle) {
        inflate(context, R.layout.video_player, this);

        evv = (EnVideoView) this.findViewById(R.id.evv);
        etb = (EnTitleBar) this.findViewById(R.id.etb);
        epc = (EnPlayController) this.findViewById(R.id.epc);
        epc.setPlayControl(this);

        evv.setOnEnVideoViewGester(this);
        evv.setOnPreparedListener(onPreparedListener);
//        evv.setOnInfoListener(onInfoListener);
        evv.setOnCompletionListener(onCompletionListener);
        evv.setOnInfoListener(onInfoListener);
//        evv.setOnCompletionListener(mCompletionListener);
//        evv.setOnErrorListener(mErrorListener);

    }

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {



        }
    };


    private MediaPlayer.OnPreparedListener onPreparedListener = new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            Log.d(TAG, "onPrepared: ");

            mHandler.sendEmptyMessage(PlayState.PREPARE);
            resetTime();

            epc.setDuration(mp.getDuration());

        }
    };

    private MediaPlayer.OnInfoListener onInfoListener = new MediaPlayer.OnInfoListener() {
        @Override
        public boolean onInfo(MediaPlayer mp, int what, int extra) {

            Log.d(TAG, "onInfo: " + what + "," + extra);

            if (what == MediaPlayer.MEDIA_INFO_BUFFERING_START) {

            }

            return false;
        }
    };





    private void resetTime() {
        stopTime();


        mTimer = new Timer();

        mTimerTask = new TimerTask() {

            @Override

            public void run() {
//                    epc.setTime(evv.getCurrentPosition());
                mHandler.sendEmptyMessage(MSG_UPDATE);

            }

        };

        mTimer.schedule(mTimerTask, 0, 1000);

    }


    private void stopTime() {

        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }

    }


    public void setVideoURI(Uri uri) {
        evv.setVideoURI(uri);
    }

    @Override
    public void start() {
        evv.start();
        resetTime();
    }


    @Override
    public void playStop() {
        evv.pause();
        stopTime();

    }

    @Override
    public boolean isPlaying() {
        return evv.isPlaying();
    }


    @Override
    public void seekTo(long progress) {

            evv.seekTo((int) progress);


    }

    @Override
    public void toFull() {
        Log.d(TAG, "toFull: ");

    }

    private void animController(){
        if (epc.getTranslationY()==0) {
            etb.animate().translationY(-etb.getHeight()).setDuration(500).start();
            epc.animate().translationY(epc.getHeight()).setDuration(500).start();
        }else {
            etb.animate().translationY(0).setDuration(500).start();
            epc.animate().translationY(0).setDuration(500).start();
        }

    }


    @Override
    public void onSingleTapUp() {
        animController();


    }

    @Override
    public void onScroll(float distanceX, float distanceY) {

        if(Math.abs(distanceX)>Math.abs(distanceY)){//横向移动距离大于纵向，只监听横向
            if(distanceX>0){
                //说明是往左滑动
            }else if(distanceX<0){

            }
            System.out.print("****************"+distanceX);
            //让videoView的播放位置移动到手势拖动后的位置(*15知识为了缩小滑动比例)
            seekTo((int) (evv.getCurrentPosition()-distanceX*seekSpeed));


        }else {

        }

    }
}
