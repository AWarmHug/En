package com.me.en.core.yixi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.me.en.R;
import com.me.en.entity.AlbumBean;
import com.me.en.widget.recycleview.recyadapter.TailRecyAdapter;

import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/4
 * 简介:
 */

public class SelectRecyAdapter extends TailRecyAdapter<AlbumBean.DataBean> {


    public SelectRecyAdapter(List<AlbumBean.DataBean> list) {
        super(list);
    }

    @Override
    protected void onContentBind(RecyclerView.ViewHolder holder, int position) {
        ((SelectViewHolder)holder).tv.setText(list.get(position).getTitle());
    }


    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        return new SelectViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_adapter_select,parent,false));

    }






     class SelectViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public SelectViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

}
