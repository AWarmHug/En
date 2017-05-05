package com.me.en.core.yixi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.me.en.core.yixi.ui.AlbumDetailFragment;
import com.me.en.entity.AlbumBean;

import java.util.List;

/**
 * Created by warm on 17/5/4.
 */

public class AlbumDetailAdapter  extends FragmentStatePagerAdapter {

    private List<AlbumBean.DataBean> mDatas;

    public AlbumDetailAdapter(FragmentManager fm,List<AlbumBean.DataBean> mDatas) {
        super(fm);
        this.mDatas = mDatas;
    }

    @Override
    public Fragment getItem(int position) {
        return AlbumDetailFragment.newInstance(mDatas.get(position));
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }
}
