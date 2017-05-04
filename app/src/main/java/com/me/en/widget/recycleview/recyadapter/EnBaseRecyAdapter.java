package com.me.en.widget.recycleview.recyadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/4/11
 * 简介:
 */
public abstract class EnBaseRecyAdapter<T> extends RecyclerView.Adapter<EnBaseRecyAdapter.EnViewHolder> {


    protected List<T> list;

    private OnItemClickListener<T> tOnItemClickListener;

    public void settOnItemClickListener(OnItemClickListener<T> tOnItemClickListener) {
        this.tOnItemClickListener = tOnItemClickListener;
    }

    public EnBaseRecyAdapter(List<T> list) {
        this.list = list;
    }


    /**
     * 在某个位置增加一个书记
     * @param position
     * @param t
     */
    public void addOneData(int position, T t) {
        list.add(position, t);
        notifyItemInserted(position);
    }

    /**
     * 在尾部增加全部
     * @param tList
     */
    public void addAllData(List<T> tList) {
        list.addAll(tList);
        notifyDataSetChanged();
    }


    /**
     * 刷新全部
     *
     * @param tList
     */
    public void refreshAll(List<T> tList) {
        list.clear();
        list.addAll(tList);
        notifyDataSetChanged();
    }

    /**
     * 删除某个位置的数据
     * @param position
     */
    public void removeData(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public EnBaseRecyAdapter.EnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return onCreate(parent, viewType);//获取资源文件
    }

    /**
     * @param parent
     * @param viewType
     * @return 获取layoutId
     */
    public abstract EnBaseRecyAdapter.EnViewHolder onCreate(ViewGroup parent, int viewType);



    @Override
    public void onBindViewHolder(EnBaseRecyAdapter.EnViewHolder holder, final int position) {

        if (tOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tOnItemClickListener.bottomClick();

                }
            });
        }
        onBind(holder,position);
    }

    protected abstract void onBind(EnBaseRecyAdapter.EnViewHolder holder, int position);

    @Override
    public int getItemCount() {

        return list == null ? 0 : list.size();


    }

    public interface OnItemClickListener<T> {
        void itemClick(int position, T t);

        void bottomClick();
    }


    public static class EnViewHolder extends RecyclerView.ViewHolder {
        public EnViewHolder(View itemView) {
            super(itemView);
        }
    }
}