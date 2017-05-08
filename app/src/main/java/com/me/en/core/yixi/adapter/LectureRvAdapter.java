package com.me.en.core.yixi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_adapter_lecture, parent, false));
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
