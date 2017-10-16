package com.me.en.core.yixi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.me.en.R;
import com.me.en.entity.Lecturer;
import com.me.en.widget.glide.GlideCircleTransform;
import com.me.en.widget.recycleview.recyadapter.EnBaseRecyAdapter;

import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/10
 * 简介:
 */

public class LecturerRvAdapter extends EnBaseRecyAdapter<Lecturer> {


    public LecturerRvAdapter(List<Lecturer> list) {
        super(list);
    }



    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        return new LecturerRvAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_adapter_lecturer,parent,false));
    }

    @Override
    protected void onBind(RecyclerView.ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(list.get(position).getPic()).bitmapTransform(new GlideCircleTransform(holder.itemView.getContext())).crossFade().into(((ViewHolder)holder).iv_header);
        ((ViewHolder)holder).tv_name.setText(list.get(position).getNickname());
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
       public ImageView iv_header;
       public TextView tv_name;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_header= (ImageView) itemView.findViewById(R.id.iv_header);
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
