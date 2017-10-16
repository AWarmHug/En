package com.me.en.core.yixi.ui;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.me.en.R;
import com.me.en.base.fragment.BaseFragment;
import com.me.en.widget.envideoplayer.widget.EnVideoPlayer;

/**
 * Created by warm on 17/5/6.
 */

public class VideoPlayFragment extends BaseFragment {
    private static final String TAG = "VideoPlayFragment";

    private EnVideoPlayer evp;

    public static VideoPlayFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url",url);
        VideoPlayFragment fragment = new VideoPlayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_video_play;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        view.setBackground(getActivity().getWindow().getDecorView().getBackground());

        evp = (EnVideoPlayer) view.findViewById(R.id.evp);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        evp.setVideoURI(Uri.parse(getArguments().getString("url")));

        evp.start();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
    }
}
