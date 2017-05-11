package com.me.en.core.yixi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;

import com.me.en.R;
import com.me.en.base.fragment.BaseFragment;
import com.me.en.core.yixi.adapter.MoreAdapter;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/9
 * 简介:
 */

public class MoreFragment extends BaseFragment implements ViewPager.OnPageChangeListener{
    private static final String TAG = "MoreFragment";

    private Toolbar tb;
    private ViewPager vp;


    public static MoreFragment newInstance() {

        Bundle args = new Bundle();

        MoreFragment fragment = new MoreFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_more;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        tb= (Toolbar) view.findViewById(R.id.tb);
        tb.setNavigationIcon(R.drawable.ic_vec_back);
        tb.setTitle("全部演讲");
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStackImmediate();
            }
        });
        tb.inflateMenu(R.menu.more);
        tb.getMenu().getItem(0).getIcon().setTint(ContextCompat.getColor(getContext(),R.color.white));
        tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.rela_main,SearchFragment.newInstance())
                        .addToBackStack(SearchFragment.class.getSimpleName())
                        .commit();
                return false;
            }
        });

        vp= (ViewPager) view.findViewById(R.id.vp);
        vp.addOnPageChangeListener(this);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MoreAdapter adapter=new MoreAdapter(getChildFragmentManager());
        vp.setAdapter(adapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tb.setTitle(position==0?"全部演讲":"全部讲者");

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
