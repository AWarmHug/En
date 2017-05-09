package com.me.en.core.yixi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.me.en.core.yixi.ui.LectureListFragment;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/9
 * 简介:
 */

public class LectureTypeVpAdapter extends FragmentStatePagerAdapter {

    private Title[] titles = {new Title("按日期", "date"), new Title("播放量", "view"), new Title("点赞数", "like")};

    public LectureTypeVpAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return LectureListFragment.newInstance(titles[position].type);

    }

    @Override
    public int getCount() {
        return titles.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position].name;
    }

    class Title {
        String name;
        String type;

        public Title(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }


}
