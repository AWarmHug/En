package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.me.en.R;
import com.me.en.base.fragment.LazyFragment;
import com.me.en.core.yixi.adapter.CommentRvAdapter;
import com.me.en.core.yixi.presenter.CommentsPresenter;
import com.me.en.core.yixi.view.CommentsView;
import com.me.en.entity.Comment;
import com.me.en.widget.recycleview.EnRecycleView;
import com.me.en.widget.recycleview.RecycleDivider;
import com.me.en.widget.recycleview.recyadapter.TailRecyAdapter;

import java.util.List;

/**
 * Created by warm on 17/5/7.
 */

public class CommentsFragment extends LazyFragment implements CommentsView{

    private CommentsPresenter presenter;

    private EnRecycleView rv_comments;

    private CommentRvAdapter adapter;

    private int page=1;
    private Toolbar tb;


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
        presenter.getComments(id,page);

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
        tb= (Toolbar) view.findViewById(R.id.tb);

        rv_comments= (EnRecycleView) view.findViewById(R.id.rv_comments);

    }

    @Override
    public void getCommentsSuccess(List<Comment> comments) {
        if (adapter==null&&comments.size()>0) {
            adapter = new CommentRvAdapter(comments);
            rv_comments.setAdapter(adapter);
            rv_comments.setLayoutManager(new LinearLayoutManager(getContext()));
            rv_comments.addItemDecoration(new RecycleDivider(getContext(),LinearLayoutManager.VERTICAL,2, ContextCompat.getColor(getContext(),R.color.black_50)));
            rv_comments.setLoadMore(new EnRecycleView.LoadMore() {
                @Override
                public void load() {
                    adapter.setState(TailRecyAdapter.LOAD);
                    presenter.getComments(id,page);
                }
            });
            adapter.setBottomView(rv_comments);
            rv_comments.setLoadF(true);

        }else if (adapter!=null&&comments.size()>0){
            adapter.addAllData(comments);
            rv_comments.setLoadF(true);

        }else if (comments==null){
            rv_comments.setLoadF(true);
            adapter.setState(TailRecyAdapter.FAIL);
        }else {
            rv_comments.setLoadF(false);
            adapter.setState(TailRecyAdapter.NO_DATA);
        }
        page++;
    }
}
