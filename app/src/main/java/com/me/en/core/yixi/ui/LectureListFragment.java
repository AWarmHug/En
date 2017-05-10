package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.me.en.R;
import com.me.en.base.fragment.LazyFragment;
import com.me.en.core.yixi.adapter.LectureRvAdapter;
import com.me.en.core.yixi.presenter.LectureTypePresenter;
import com.me.en.core.yixi.view.LectureTypeView;
import com.me.en.entity.Lecture;
import com.me.en.widget.recycleview.recyadapter.EnBaseRecyAdapter;

import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/9
 * 简介:
 */

public class LectureListFragment extends LazyFragment implements LectureTypeView{
    private static final String TAG = "LectureListFragment";


    private LectureTypePresenter presenter;


    private RecyclerView rv;

    private String type;




    public static LectureListFragment newInstance(String type) {

        Bundle args = new Bundle();
        args.putString("type",type);
        LectureListFragment fragment = new LectureListFragment();
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    protected void doInVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void doFirstVisible(@Nullable Bundle savedInstanceState) {
        type=getArguments().getString("type");

        presenter=new LectureTypePresenter(this);
        presenter.getLectureDate(type,1);


    }

    @Override
    protected void doVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_recy;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        rv= (RecyclerView) view.findViewById(R.id.rv);


    }

    @Override
    public void getLectureTypeSuccess(final List<Lecture> lectures) {
        LectureRvAdapter adapter=new LectureRvAdapter(lectures);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter.settOnItemClickListener(new EnBaseRecyAdapter.OnItemClickListener<Lecture>() {
            @Override
            public void itemClick(int position, Lecture lecture) {
               getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.rela_main, LectureFragment.newInstance(lecture.getId()))
                        .addToBackStack(null)
                        .commit();
            }
        });


    }
}
