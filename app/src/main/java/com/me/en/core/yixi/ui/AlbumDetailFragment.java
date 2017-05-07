package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.me.en.R;
import com.me.en.base.fragment.LazyFragment;
import com.me.en.core.yixi.adapter.AlbumDetailRvAdapter;
import com.me.en.entity.AlbumBean;
import com.me.en.entity.Lecture;
import com.me.en.entity.Tag;
import com.me.en.widget.recycleview.EnRecycleView;

/**
 * Created by warm on 17/5/4.
 */

public class AlbumDetailFragment extends LazyFragment implements AlbumDetailRvAdapter.OnAlbumDetailClickListener {
    private static final String TAG = "AlbumDetailFragment";

    private EnRecycleView rv_detail;


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
        rv_detail = (EnRecycleView) view.findViewById(R.id.rv_detail);

    }


    @Override
    protected void doInVisible(@Nullable Bundle savedInstanceState) {

    }


    @Override
    protected void doFirstVisible(@Nullable Bundle savedInstanceState) {
        data = getArguments().getParcelable("data");
        AlbumDetailRvAdapter adapter=new AlbumDetailRvAdapter(data);
        rv_detail.setAdapter(adapter);
        rv_detail.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setOnAlbumDetailClickListener(this);




    }

    @Override
    protected void doVisible(@Nullable Bundle savedInstanceState) {

    }


    @Override
    public void clickLookDetail(Lecture lecture) {

        getFragmentManager()
                .beginTransaction()
                .add(R.id.fl_lecture_detail,LectureFragment.newInstance(lecture.getId()))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void clickLookTag(Tag tag) {
        Toast.makeText(getContext(), tag.getName(), Toast.LENGTH_SHORT).show();

    }
}
