package com.me.en.core.yixi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by warm on 17/5/11.
 */

public class SearchRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class HotViewHolder extends RecyclerView.ViewHolder {
        public HotViewHolder(View itemView) {
            super(itemView);
        }
    }


}
