package com.me.en.core.yixi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.me.en.R;
import com.me.en.base.fragment.LazyFragment;
import com.me.en.entity.AlbumBean;
import com.me.en.utils.PicUtils;

/**
 * Created by warm on 17/5/4.
 */

public class AlbumDetailFragment extends LazyFragment {
    private static final String TAG = "AlbumDetailFragment";


    private RelativeLayout rl;
    private ImageView iv_background;
    private TextView tv_title, tv_desc;


    private AlbumBean.DataBean data;

    public static AlbumDetailFragment newInstance(AlbumBean.DataBean data) {

        Bundle args = new Bundle();
        args.putParcelable("data", data);

        AlbumDetailFragment fragment = new AlbumDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_album_detail;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        rl = (RelativeLayout) view.findViewById(R.id.rl);
        iv_background = (ImageView) view.findViewById(R.id.iv_background);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_desc = (TextView) view.findViewById(R.id.tv_desc);

    }


    @Override
    protected void doInVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "initView: " + findSuitableParent(rl).getHeight());

        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,findSuitableParent(rl).getHeight());

        rl.setLayoutParams(lp2);




//        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(rl.getLayoutParams());
//        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//        tv_desc.setLayoutParams(lp);

    }

    @Override
    protected void doFirstVisible(@Nullable Bundle savedInstanceState) {
        data = getArguments().getParcelable("data");

        Log.d(TAG, "doFirstVisible: "+PicUtils.change(data.getBackground()));
        Glide.with(this)
                .load(data.getBackground().replaceAll(".1536x1000","")).asBitmap().centerCrop().into(iv_background);

        tv_title.setText(data.getTitle());
        tv_desc.setText(data.getDesc());

    }

    @Override
    protected void doVisible(@Nullable Bundle savedInstanceState) {

    }


    private ViewGroup findSuitableParent(View view) {
        ViewGroup fallback = null;
        do {
            if (view instanceof FrameLayout) {
                if (view.getId() == android.R.id.content) {
                    // If we've hit the decor content view, then we didn't find a CoL in the
                    // hierarchy, so use it.
                    return (ViewGroup) view;
                } else {
                    // It's not the content view but we'll use it as our fallback
                    fallback = (ViewGroup) view;
                }
            }

            if (view != null) {
                // Else, we will loop and crawl up the view hierarchy and try to find a parent
                final ViewParent parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
        } while (view != null);

        // If we reach here then we didn't find a CoL or a suitable content view so we'll fallback
        return fallback;
    }
}
