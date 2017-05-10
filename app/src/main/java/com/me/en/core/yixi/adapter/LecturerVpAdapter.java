package com.me.en.core.yixi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.me.en.core.yixi.ui.LecturerListFragment;
import com.me.en.entity.Category;

import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/10
 * 简介:
 */

public class LecturerVpAdapter extends FragmentStatePagerAdapter {

    private List<Category> categories;


    public LecturerVpAdapter(FragmentManager fm,List<Category> categories) {
        super(fm);
        this.categories=categories;
    }

    @Override
    public Fragment getItem(int position) {
        return LecturerListFragment.newInstance(categories.get(position).getId());
    }

    @Override
    public int getCount() {
        return categories.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).getName();
    }
}
