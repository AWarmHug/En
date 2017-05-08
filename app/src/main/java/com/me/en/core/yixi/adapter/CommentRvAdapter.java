package com.me.en.core.yixi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.me.en.entity.Comment;
import com.me.en.widget.recycleview.recyadapter.TailRecyAdapter;

import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/8
 * 简介:
 */

public class CommentRvAdapter extends TailRecyAdapter<Comment> {

    public CommentRvAdapter(List<Comment> list) {
        super(list);
    }

    @Override
    protected void onContentBind(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        return null;
    }

}
