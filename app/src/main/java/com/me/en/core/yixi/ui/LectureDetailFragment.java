package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.me.en.R;
import com.me.en.base.fragment.LazyFragment;
import com.me.en.core.yixi.adapter.LectureRvAdapter;
import com.me.en.core.yixi.presenter.LectureDetailPresenter;
import com.me.en.core.yixi.view.LectureDetailView;
import com.me.en.entity.Error;
import com.me.en.entity.Lecture;
import com.me.en.entity.Video;
import com.me.en.widget.glide.GlideCircleTransform;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/5
 * 简介:
 */

public class LectureDetailFragment extends LazyFragment implements LectureDetailView {

    private LectureDetailPresenter presenter;

    private int id;

    private NestedScrollView nsv;
    private TextView tv_purecontent, tv_lecturer_name, tv_lecturer_desc, tv_title, tv_site_time, tv_desc, tv_toArticle;
    private ImageView iv_background, iv_lecturer_header, iv_play;
    private LinearLayout ll_related;

    public static LectureDetailFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("id", id);
        LectureDetailFragment fragment = new LectureDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_lecture_detail;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        nsv= (NestedScrollView) view.findViewById(R.id.nsv);
        iv_background = (ImageView) view.findViewById(R.id.iv_background);
        iv_lecturer_header = (ImageView) view.findViewById(R.id.iv_lecturer_header);
        tv_lecturer_name = (TextView) view.findViewById(R.id.tv_lecturer_name);
        tv_lecturer_desc = (TextView) view.findViewById(R.id.tv_lecturer_desc);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_site_time = (TextView) view.findViewById(R.id.tv_site_time);
        tv_desc = (TextView) view.findViewById(R.id.tv_desc);
        iv_play = (ImageView) view.findViewById(R.id.iv_play);
        tv_toArticle = (TextView) view.findViewById(R.id.tv_toArticle);
        tv_purecontent = (TextView) view.findViewById(R.id.tv_purecontent);
        ll_related = (LinearLayout) view.findViewById(R.id.ll_related);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void doInVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void doFirstVisible(@Nullable Bundle savedInstanceState) {
        id = getArguments().getInt("id", 0);
        presenter = new LectureDetailPresenter(this);
        presenter.getLecture(id);
    }

    @Override
    protected void doVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void getLectureDetailSuccess(final Lecture lecture) {

        Log.d("TAG", "onAnimationEnd: ");
        Glide.with(LectureDetailFragment.this).load(!TextUtils.isEmpty(lecture.getBackground())?lecture.getBackground():lecture.getLecturer().getBackground()).crossFade().centerCrop().into(iv_background);
        Glide.with(LectureDetailFragment.this).load(lecture.getLecturer().getPic()).crossFade().transform(new GlideCircleTransform(getContext())).into(iv_lecturer_header);
        tv_lecturer_name.setText(lecture.getLecturer().getNickname());
        tv_lecturer_desc.setText(lecture.getLecturer().getDesc());
        tv_title.setText(lecture.getTitle());
        tv_site_time.setText(lecture.getSite() + " | " + lecture.getTime());
        tv_desc.setText(lecture.getDesc());
        Glide.with(LectureDetailFragment.this).load(lecture.getCover()).crossFade().centerCrop().into(iv_play);
        iv_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().getSupportFragmentManager()
//                        .beginTransaction()
//                        .setCustomAnimations(R.anim.activity_new_in, R.anim.activity_new_out, R.anim.activity_old_in, R.anim.activity_old_out)
//                        .add(R.id.rela_main, VideoPlayFragment.newInstance("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4"))
//                        .addToBackStack(null)
//                        .commit();
                presenter.getLecturePlay(lecture.getId(), lecture.getVideo());
            }
        });
        tv_toArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_toArticle.setVisibility(View.GONE);
                tv_purecontent.setText(lecture.getPurecontent());

            }
        });


        tv_purecontent.setText(lecture.getPurecontent().substring(0, 200));




    }

    @Override
    public void getLectureDetailFail(Error e) {


    }

    @Override
    public void getLecturePlaySuccess(Video video) {
        Toast.makeText(getContext(), "获取视频成功!", Toast.LENGTH_SHORT).show();
       getActivity().getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.activity_new_in, R.anim.activity_new_out, R.anim.activity_old_in, R.anim.activity_old_out)
                .add(R.id.rela_main, VideoPlayFragment.newInstance(video.getFiles().get_$3gphd().getSegs().get(0).getUrl()))
                .addToBackStack(null)
                .commit();


    }

    @Override
    public void getLecturePlayFail(Error e) {
        Snackbar.make(ll_related,"获取视频失败！",Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void getRelatedS(final Lecture lecture) {
        LectureRvAdapter.ViewHolder viewHolder = new LectureRvAdapter.ViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.recy_adapter_lecture, ll_related, false));
        viewHolder.tv_title.setText(lecture.getTitle());
        viewHolder.tv_lecture_time_site.setText(lecture.getTime() + " | "+lecture.getSite());
        viewHolder.tv_viewnum.setText(String.valueOf(lecture.getViewnum()));
        viewHolder.tv_lecturer_name.setText(lecture.getLecturer().getNickname());
        Glide.with(this).load(lecture.getCover()).crossFade().centerCrop().into(viewHolder.iv_cover);

        ll_related.addView(viewHolder.itemView);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.rela_main, LectureFragment.newInstance(lecture.getId()))
                        .addToBackStack(null)
                        .commit();
            }
        });


    }



}
