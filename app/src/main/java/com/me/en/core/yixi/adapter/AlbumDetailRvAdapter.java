package com.me.en.core.yixi.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.me.en.R;
import com.me.en.entity.AlbumBean;
import com.me.en.entity.Lecture;
import com.me.en.entity.Tag;
import com.me.en.widget.flowlayout.FlowLayout;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/5
 * 简介:
 */

public class AlbumDetailRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "AlbumDetailRvAdapter";
    private AlbumBean.DataBean data;

    private final int TOP = -1;
    private final int SECOND = -2;

    private OnAlbumDetailClickListener onAlbumDetailClickListener;

    public void setOnAlbumDetailClickListener(OnAlbumDetailClickListener onAlbumDetailClickListener) {
        this.onAlbumDetailClickListener = onAlbumDetailClickListener;
    }

    public AlbumDetailRvAdapter(AlbumBean.DataBean data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TOP:

                return new TopViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_adapter_album_detail_top, parent, false));
            default:
                return new SecondViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_adapter_album_detail_second, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TOP:
                ((TopViewHolder) holder).tv_title.setText(data.getTitle());
                ((TopViewHolder) holder).tv_desc.setText(data.getDesc());

                Log.d("okhttp", "onBindViewHolder: " + data.getBackground());
                Glide.with(((TopViewHolder) holder).itemView.getContext()).load(data.getBackground()).centerCrop().crossFade().into(((TopViewHolder) holder).iv_background);

                break;
            case SECOND:
                ((SecondViewHolder) holder).tv_purecontent.setText(data.getPurecontent());
                ((SecondViewHolder) holder).tv_title.setText(data.getLectures().get(0).getTitle());
                ((SecondViewHolder) holder).tv_desc.setText(data.getLectures().get(0).getDesc());
                ((SecondViewHolder) holder).tv_nickname.setText(data.getLectures().get(0).getLecturer().getNickname());
                ((SecondViewHolder) holder).tv_time.setText(data.getLectures().get(0).getCreated_at());

                Glide.with(((SecondViewHolder) holder).itemView.getContext()).load(!TextUtils.isEmpty(data.getLectures().get(0).getBackground())?data.getLectures().get(0).getBackground():data.getLectures().get(0).getLecturer().getBackground()).centerCrop().crossFade().into(((SecondViewHolder)holder).iv_cover);

                for (Tag tag : data.getLectures().get(0).getTags()) {
                    ((SecondViewHolder) holder).fl.addView(buildLabel(((SecondViewHolder) holder).itemView.getContext(), tag));
                    Log.d(TAG, "onBindViewHolder: ");
                }
                ((SecondViewHolder) holder).fl.requestLayout();

                ((SecondViewHolder) holder).cv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onAlbumDetailClickListener.clickLookDetail(data.getLectures().get(0));
                    }
                });



                break;
        }


    }


    private TextView buildLabel(final Context mContext, final Tag tag) {

        TextView textView = new TextView(mContext);
        textView.setText(tag.getName());
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        textView.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        textView.setPadding(20, 20, 20, 20);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAlbumDetailClickListener.clickLookTag(tag);
            }
        });
        return textView;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TOP;
        } else {
            return SECOND;
        }
    }

    class TopViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout rl;
        ImageView iv_background;
        TextView tv_title, tv_desc;

        public TopViewHolder(View itemView) {
            super(itemView);
            rl = (RelativeLayout) itemView.findViewById(R.id.rl);
            iv_background = (ImageView) itemView.findViewById(R.id.iv_background);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);
        }
    }

    class SecondViewHolder extends RecyclerView.ViewHolder {

        TextView tv_purecontent, tv_title,tv_desc,tv_nickname,tv_time;
        CardView cv;
        FlowLayout fl;
        ImageView iv_cover;

        public SecondViewHolder(View itemView) {
            super(itemView);
            tv_purecontent = (TextView) itemView.findViewById(R.id.tv_purecontent);
            cv = (CardView) itemView.findViewById(R.id.cv);
            iv_cover= (ImageView) itemView.findViewById(R.id.iv_cover);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_desc= (TextView) itemView.findViewById(R.id.tv_desc);
            tv_nickname= (TextView) itemView.findViewById(R.id.tv_nickname);
            tv_time= (TextView) itemView.findViewById(R.id.tv_time);

            fl = (FlowLayout) itemView.findViewById(R.id.fl);
        }
    }


   public interface OnAlbumDetailClickListener{
        void clickLookDetail(Lecture lecture);

        void clickLookTag(Tag tag);
    }



}
