package com.me.en.core.yixi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.me.en.core.yixi.ui.CommentsFragment;
import com.me.en.core.yixi.ui.LectureDetailFragment;

/**
 * Created by warm on 17/5/7.
 */

public class LectureVpAdapter extends FragmentStatePagerAdapter {
    private int id;

    public LectureVpAdapter(FragmentManager fm,int id) {
        super(fm);
        this.id=id;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return LectureDetailFragment.newInstance(id);
            case 1:
                return CommentsFragment.newInstance(id);
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);

    }
}
