package com.me.en.core.yixi.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.me.en.R;
import com.me.en.base.fragment.BaseFragment;

/**
 * Created by warm on 17/5/6.
 */

public class VideoPlayFragment extends BaseFragment {

    private VideoView vv;

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
        vv= (VideoView) view.findViewById(R.id.vv);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        vv.setMediaController(new MediaController(getContext()));

        vv.setVideoURI(Uri.parse(getArguments().getString("url")));


        vv.start();

    }


}
