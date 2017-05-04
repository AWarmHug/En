package com.me.en.core.openeye.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.me.en.R;
import com.me.en.entity.SelectBean;
import com.me.en.widget.recycleview.recyadapter.EnBaseRecyAdapter;
import com.me.en.widget.recycleview.recyadapter.TailRecyAdapter;

import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/4
 * 简介:
 */

public class SelectRecyAdapter extends TailRecyAdapter<SelectBean.ItemListBean> {


    public SelectRecyAdapter(List<SelectBean.ItemListBean> list) {
        super(list);


    }

    @Override
    public EnViewHolder onCreate(ViewGroup parent, int viewType) {
        return new SelectViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_adapter_select,parent,false));
    }

    @Override
    protected void onBind(EnViewHolder holder, int position) {
        ((SelectViewHolder) holder).tv.setText(list.get(position).getData().getTitle());
    }

    static class SelectViewHolder extends EnViewHolder {
        TextView tv;

        public SelectViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

}
