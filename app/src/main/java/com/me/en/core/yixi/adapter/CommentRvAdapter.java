package com.me.en.core.yixi.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.me.en.R;
import com.me.en.entity.Comment;
import com.me.en.widget.glide.GlideCircleTransform;
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
        if (!TextUtils.isEmpty(list.get(position).getUser().getPic())){
            Glide.with(holder.itemView.getContext())
                    .load(list.get(position).getUser().getPic())
                    .bitmapTransform(new GlideCircleTransform(holder.itemView.getContext()))
                    .into(((ViewHolder)holder).iv_header);
        }else {
            ((ViewHolder)holder).iv_header.setImageResource(R.drawable.ic_vec_header);
        }

        ((ViewHolder)holder).tv_name.setText(list.get(position).getUser().getNickname());
        ((ViewHolder)holder).tv_time.setText(list.get(position).getCreated_at());
        ((ViewHolder)holder).tv_desc.setText(list.get(position).getContent());
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_adapter_comment,parent,false));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_header;
        TextView tv_name,tv_time,tv_desc;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_header= (ImageView) itemView.findViewById(R.id.iv_header);
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
            tv_time= (TextView) itemView.findViewById(R.id.tv_time);
            tv_desc= (TextView) itemView.findViewById(R.id.tv_desc);

        }
    }

}
