package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
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

/**
 * 作者: 51hs_android
 * 时间: 2017/5/5
 * 简介:
 */

public class LectureDetailFragment extends BaseFragment implements LectureDetailView,View.OnTouchListener{

    private LectureDetailPresenter presenter;

    private int id;

    private TextView  tv_purecontent;
    private ImageView iv_background;

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
        view.setOnTouchListener(this);

        iv_background= (ImageView) view.findViewById(R.id.iv_background);
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
    public void getLectureDetailSuccess(Lecture lecture) {
        Toast.makeText(getContext(), lecture.getDesc(), Toast.LENGTH_SHORT).show();

        Glide.with(this).load(lecture.getBackground()).asBitmap().centerCrop().into(iv_background);
        tv_purecontent.setText(lecture.getPurecontent());

    }

    @Override
    public void getLectureDetailFail(Error e) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}
