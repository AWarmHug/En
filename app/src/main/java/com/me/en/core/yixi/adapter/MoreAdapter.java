package com.me.en.core.yixi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.me.en.core.yixi.ui.LectureTypeFragment;
import com.me.en.core.yixi.ui.LecturerFragment;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/9
 * 简介:
 */

public class MoreAdapter extends FragmentStatePagerAdapter {


    public MoreAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position==0){
            return LectureTypeFragment.newInstance();
        }else {
            return LecturerFragment.newInstance();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
