package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.me.en.R;
import com.me.en.base.fragment.LazyFragment;
import com.me.en.core.yixi.presenter.CommentsPresenter;
import com.me.en.core.yixi.view.CommentsView;
import com.me.en.entity.Comment;

import java.util.List;

/**
 * Created by warm on 17/5/7.
 */

public class CommentsFragment extends LazyFragment implements CommentsView{

    private CommentsPresenter presenter;

    private RecyclerView rv_comments;


    private int id;

    public static CommentsFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("id",id);
        CommentsFragment fragment = new CommentsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void doInVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void doFirstVisible(@Nullable Bundle savedInstanceState) {
        id=getArguments().getInt("id");

        presenter=new CommentsPresenter(this);
        presenter.getComments(id,0);

    }

    @Override
    protected void doVisible(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_comments;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        rv_comments= (RecyclerView) view.findViewById(R.id.rv_comments);

    }

    @Override
    public void getCommentsSuccess(List<Comment> comments) {
        Toast.makeText(getContext(), "评论数量:"+comments.size(), Toast.LENGTH_SHORT).show();

    }
}
