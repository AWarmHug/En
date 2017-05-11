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
import com.me.en.entity.Lecture;
import com.me.en.widget.recycleview.recyadapter.TailRecyAdapter;

import java.util.List;

/**
 * Created by warm on 17/5/8.
 */

public class LectureRvAdapter extends TailRecyAdapter<Lecture> {

    public LectureRvAdapter(List<Lecture> list) {
        super(list);
    }

    @Override
    protected void onContentBind(RecyclerView.ViewHolder holder, int position) {
        ((NewViewHolder) holder).tv_title.setText(list.get(position).getTitle());
        ((NewViewHolder) holder).tv_lecture_time_site.setText(list.get(position).getTime() + " | " + list.get(position).getSite());
        ((NewViewHolder) holder).tv_viewnum.setText(String.valueOf(list.get(position).getViewnum()));
        ((NewViewHolder) holder).tv_lecturer_name.setText(list.get(position).getLecturer().getNickname());
        Glide.with(holder.itemView.getContext()).load(!TextUtils.isEmpty(list.get(position).getBackground())?list.get(position).getBackground():!TextUtils.isEmpty(list.get(position).getBackground())?list.get(position).getLecturer().getBackground():list.get(position).getCover().replace(".315x210",".1242x701")).crossFade().centerCrop().into(((NewViewHolder) holder).iv_cover);


    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        return new NewViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_adapter_lecture_list, parent, false));
    }


    public static class NewViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_cover;
        public TextView tv_title, tv_lecture_time_site, tv_lecturer_name, tv_viewnum;

        public NewViewHolder(View itemView) {
            super(itemView);
            iv_cover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_lecture_time_site = (TextView) itemView.findViewById(R.id.tv_lecture_time_site);
            tv_lecturer_name = (TextView) itemView.findViewById(R.id.tv_lecturer_name);
            tv_viewnum = (TextView) itemView.findViewById(R.id.tv_viewnum);
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_cover;
        public TextView tv_title, tv_lecture_time_site, tv_lecturer_name, tv_viewnum;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_cover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_lecture_time_site = (TextView) itemView.findViewById(R.id.tv_lecture_time_site);
            tv_lecturer_name = (TextView) itemView.findViewById(R.id.tv_lecturer_name);
            tv_viewnum = (TextView) itemView.findViewById(R.id.tv_viewnum);
        }
    }


}
