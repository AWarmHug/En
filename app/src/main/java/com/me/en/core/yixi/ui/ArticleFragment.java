package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.me.en.R;
import com.me.en.base.fragment.BaseFragment;
import com.me.en.entity.Lecture;

/**
 * Created by warm on 17/5/7.
 */

public class ArticleFragment extends BaseFragment {

    private TextView tv_title;
    private TextView tv_name;
    private TextView tv_body;
    private Lecture lecture;

    public static ArticleFragment newInstance(Lecture lecture) {

        Bundle args = new Bundle();
        args.putParcelable("lecture",lecture);
        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    protected int getLayout() {
        return R.layout.fragment_article;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        tv_title= (TextView) view.findViewById(R.id.tv_title);
        tv_name= (TextView) view.findViewById(R.id.tv_name);

        tv_body= (TextView) view.findViewById(R.id.tv_body);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lecture=getArguments().getParcelable("lecture");
        tv_title.setText(lecture.getTitle());
        tv_name.setText(lecture.getLecturer().getNickname());
        tv_body.setText(lecture.getPurecontent());

    }
}
