package com.me.en.core.yixi.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.me.en.R;
import com.me.en.base.fragment.BaseFragment;
import com.me.en.core.yixi.adapter.AlbumDetailRvAdapter;
import com.me.en.entity.AlbumBean;
import com.me.en.entity.Lecture;
import com.me.en.entity.Tag;

/**
 * Created by warm on 17/5/4.
 */

public class AlbumDetailFragment extends BaseFragment {
    private static final String TAG = "AlbumDetailFragment";

    private RelativeLayout rl_album;
    private NestedScrollView nsv;
    private LinearLayout ll_album_detail;
    private AlbumDetailRvAdapter.TopViewHolder topViewHolder;
    private AlbumDetailRvAdapter.SecondViewHolder secondViewHolder;

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
        rl_album= (RelativeLayout) view.findViewById(R.id.rl_album);


        nsv = (NestedScrollView) view.findViewById(R.id.nsv);
        ll_album_detail = (LinearLayout) view.findViewById(R.id.ll_album_detail);

        topViewHolder = new AlbumDetailRvAdapter.TopViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.recy_adapter_album_detail_top, ll_album_detail, false));
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, nsv.getLayoutParams().height);
        topViewHolder.rl.setLayoutParams(lp);
        secondViewHolder = new AlbumDetailRvAdapter.SecondViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.recy_adapter_album_detail_second, ll_album_detail, false));


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        data = getArguments().getParcelable("data");



        topViewHolder.tv_title.setText(data.getTitle());
        topViewHolder.tv_desc.setText(data.getDesc());



        Glide.with(getContext()).load(data.getBackground()).crossFade().into(topViewHolder.iv_background);

        secondViewHolder.tv_purecontent.setText(data.getPurecontent());
        secondViewHolder.tv_title.setText(data.getLectures().get(0).getTitle());
        secondViewHolder.tv_desc.setText(data.getLectures().get(0).getDesc());
        secondViewHolder.tv_nickname.setText(data.getLectures().get(0).getLecturer().getNickname());
        secondViewHolder.tv_time.setText(data.getLectures().get(0).getCreated_at());

        Glide.with(getContext()).load(!TextUtils.isEmpty(data.getLectures().get(0).getBackground()) ? data.getLectures().get(0).getBackground() : data.getLectures().get(0).getLecturer().getBackground()).centerCrop().crossFade().into(secondViewHolder.iv_cover);

        for (Tag tag : data.getLectures().get(0).getTags()) {
            secondViewHolder.fl.addView(buildLabel(secondViewHolder.itemView.getContext(), tag));
            Log.d(TAG, "onBindViewHolder: ");
        }
        secondViewHolder.fl.requestLayout();

        secondViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLookDetail(data.getLectures().get(0));
            }
        });

        ll_album_detail.addView(topViewHolder.itemView);
        ll_album_detail.addView(secondViewHolder.itemView);




    }

    private TextView buildLabel(final Context mContext, final Tag tag) {

        TextView textView = new TextView(mContext);
        textView.setText(tag.getName());
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        textView.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        textView.setPadding(20, 20, 20, 20);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLookTag(tag);
            }
        });
        return textView;
    }

    /**
     * copy from SnackBar 源码
     * @param view
     * @return
     */
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




    public void clickLookDetail(Lecture lecture) {

        LectureFragment lectureFragment = LectureFragment.newInstance(lecture.getId());

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.rl_album, lectureFragment)
                .addToBackStack(null)
                .commit();
    }

    public void clickLookTag(Tag tag) {
        Toast.makeText(getContext(), tag.getName(), Toast.LENGTH_SHORT).show();

    }
}
