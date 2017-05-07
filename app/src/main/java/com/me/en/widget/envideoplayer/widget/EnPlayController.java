package com.me.en.widget.envideoplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.me.en.R;

import java.util.Formatter;
import java.util.Locale;

/**
 * Created by warm on 17/5/6.
 */

public class EnPlayController extends RelativeLayout implements SeekBar.OnSeekBarChangeListener,View.OnClickListener{

    /**
     * 百分之1,seekbar滑动的时间
     */
    private long durat;

    private ImageButton bt_play,bt_full;
    private TextView tv_time;
    private SeekBar sb_progress;

    private StringBuilder mFormatBuilder;
    private Formatter mFormatter;
    private PlayControl playControl;

    public void setPlayControl(PlayControl playControl) {
        this.playControl = playControl;
    }

    public EnPlayController(Context context) {
        this(context, null);
    }

    public EnPlayController(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EnPlayController(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    initView(context,attrs,defStyle);
    }

    private void initView(Context context, AttributeSet attrs, int defStyle) {

        inflate(context, R.layout.view_play_controller,this);

        bt_play= (ImageButton) findViewById(R.id.bt_play);
        bt_play.setOnClickListener(this);
        tv_time= (TextView) findViewById(R.id.tv_time);
        sb_progress= (SeekBar) findViewById(R.id.sb_progress);
        sb_progress.setOnSeekBarChangeListener(this);
        sb_progress.setSecondaryProgress(0);
        bt_full= (ImageButton) findViewById(R.id.bt_full);
        bt_full.setOnClickListener(this);
        mFormatBuilder = new StringBuilder();
         mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());
    }



    private String stringForTime(int timeMs) {
        int totalSeconds = timeMs / 1000;

        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours   = totalSeconds / 3600;

        mFormatBuilder.setLength(0);
        if (hours > 0) {
            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } else {
            return mFormatter.format("%02d:%02d", minutes, seconds).toString();
        }
    }

    public void setDuration(long duration) {
        this.durat =  (duration/100);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.d("seek", "onProgressChanged: "+progress);
        Log.d("seek", "onProgressChanged: "+seekBar.getSecondaryProgress());
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        playControl.seekTo(seekBar.getProgress()>99?99*durat:seekBar.getProgress()*durat);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_play:
                switchPlay(playControl.isPlaying());
                break;
            case R.id.bt_full:
                playControl.toFull();
                break;
        }
    }

    public void switchPlay(boolean isPlaying){
        if (isPlaying){
            playControl.playStop();
            bt_play.setImageResource(R.drawable.ic_vec_play_small);
        }else {
            playControl.start();

            bt_play.setImageResource(R.drawable.ic_vec_play_stop_small);

        }
    }


    public void switchFullBt(int state){

        if (true){
            bt_full.setImageResource(R.drawable.ic_vec_play_nofull);
        }else {
            bt_full.setImageResource(R.drawable.ic_vec_play_tofull);
        }


    }

    public void updataProgress(int m,int progress){
        updataProgress(m,progress,0);

    }


    public void updataProgress(int m,int progress,int secondProgress){
        Log.d("EnVideoPlayer", "updataProgress: "+progress+","+secondProgress);

        tv_time.setText(stringForTime(m));

        sb_progress.setProgress(progress);
//        sb_progress.setSecondaryProgress(secondProgress);
    }



    interface PlayControl{



        void start();

        void playStop();

        boolean isPlaying();


        void seekTo(long milliseconds);

        void toFull();


    }

}
