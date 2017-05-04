package com.me.en.widget.recycleview.recyadapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/4/12
 * 简介:
 */

public abstract class TailRecyAdapter<T> extends EnBaseRecyAdapter<T> {

    private static final String TAG = "ArticleRecyAdapter3";

    private final int BOTTOM=0;

    private View bottomView;

    public TailRecyAdapter(List<T> list) {
        super(list);
    }

    public void addBottomView(View bottomView) {
        this.bottomView = bottomView;
    }

    /**
     * 控制RecycleView上拉加载数据状态
     */
    private int state;


    /**
     * 加载失败 用于
     */
    public static final int FAIL = -1;
    /**
     * 加载成功 用于
     */
    public static final int SUCCESS = 0;
    /**
     * 加载成功，但是没有数据了
     */
    public static final int NO_DATA = 1;

    /**
     * 恢复加载状态,
     */
    public static final int LOAD =2;


    private LoadMoreView loadMoreView;



    /**
     * 添加尾部
     *
     * @param rv
     * @throws Exception 在添加尾部前需要先给RecyclerView设置LayoutManger
     */
    public void setBottomView(RecyclerView rv) {

        if (rv.getLayoutManager() == null){
            Log.d(TAG, "setBottomView: 需要先设置LayoutManager");
        } else {
            loadMoreView = new LoadMoreView(rv);
            addBottomView(loadMoreView.getContent());
        }

    }

    @Override
    public EnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==BOTTOM){
            return new EnViewHolder(bottomView);

        }else {
            return super.onCreateViewHolder(parent, viewType);
        }
    }


    @Override
    public int getItemViewType(int position) {

        if (position != list.size()) {

            return super.getItemViewType(position);
        } else {
            return BOTTOM;
        }

    }


    @Override
    public int getItemCount() {
        if (bottomView!=null){
            return super.getItemCount()==0?0:super.getItemCount()+1;

        }else {
            return super.getItemCount();
        }
    }

    /**
     * 开始加载
     */
    public void startLoad() {
        loadMoreView.setText("正在加载，请稍后！");
        loadMoreView.setPbVisibility(View.VISIBLE);
    }


    public void addData(List<T> list, int state) {
        addAllData(list);

        finishLoad(state);
    }



    /**
     * 加载结束
     *
     * @param state 状态码
     */
    public void finishLoad(int state) {
        switch (state) {
            case FAIL:
                loadMoreView.setText("加载失败，点击重新加载！");
                break;
            case SUCCESS:
                loadMoreView.setText("加载成功！");
                break;
            case NO_DATA:
                loadMoreView.setText("加载完毕，没有更多数据！");
                break;
            case LOAD:

                break;
        }
        loadMoreView.setPbVisibility(View.GONE);
    }




}
