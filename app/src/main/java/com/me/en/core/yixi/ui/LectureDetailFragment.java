package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.me.en.R;
import com.me.en.base.fragment.BaseFragment;
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

public class LectureDetailFragment extends BaseFragment implements LectureDetailView{

    private LectureDetailPresenter presenter;

    private int id;

    private TextView  tv_purecontent, tv_lecturer_name,tv_lecturer_desc,tv_title,tv_site_time,tv_desc;
    private ImageView iv_background,iv_lecturer_header,iv_play;

    public static LectureDetailFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("id",id);
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

        iv_background= (ImageView) view.findViewById(R.id.iv_background);
        iv_lecturer_header= (ImageView) view.findViewById(R.id.iv_lecturer_header);
        tv_lecturer_name = (TextView) view.findViewById(R.id.tv_lecturer_name);
        tv_lecturer_desc= (TextView) view.findViewById(R.id.tv_lecturer_desc);
        tv_title= (TextView) view.findViewById(R.id.tv_title);
        tv_site_time= (TextView) view.findViewById(R.id.tv_site_time);
        tv_desc= (TextView) view.findViewById(R.id.tv_desc);
        iv_play= (ImageView) view.findViewById(R.id.iv_play);


        tv_purecontent= (TextView) view.findViewById(R.id.tv_purecontent);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        id=getArguments().getInt("id",0);

        presenter=new LectureDetailPresenter(this);

        presenter.getLecture(id);


    }

    @Override
    public void getLectureDetailSuccess(final Lecture lecture) {

        Glide.with(this).load(lecture.getBackground()).asBitmap().centerCrop().into(iv_background);
        Glide.with(this).load(lecture.getLecturer().getPic()).asBitmap().transform(new GlideCircleTransform(getContext())).into(iv_lecturer_header);
        tv_lecturer_name.setText(lecture.getLecturer().getNickname());
        tv_lecturer_desc.setText(lecture.getLecturer().getDesc());
        tv_title.setText(lecture.getTitle());
        tv_site_time.setText(lecture.getSite()+" | "+lecture.getTime());
        tv_desc.setText(lecture.getDesc());
        Glide.with(this).load(lecture.getCover()).asBitmap().centerCrop().into(iv_play);
        iv_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getLecturePlay(lecture.getId(),lecture.getVideo());
            }
        });



        tv_purecontent.setText(lecture.getPurecontent().substring(0,200));

    }

    @Override
    public void getLectureDetailFail(Error e) {


    }

    @Override
    public void getLecturePlaySuccess(Video video) {
        Toast.makeText(getContext(), "获取视频成功!", Toast.LENGTH_SHORT).show();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.fl_play,VideoPlayFragment.newInstance(video.getFiles().get_$3gphd().getSegs().get(0).getUrl()))
                .addToBackStack(null)
                .commit();


    }


}
