package com.me.en.core;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.me.en.R;
import com.me.en.base.activity.BaseActivity;
import com.me.en.core.yixi.adapter.MainAdapter;


public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener,ViewPager.OnPageChangeListener{
    private static final String TAG = "MainActivity111";
    private RelativeLayout relaMain;
    private ViewPager vpMain;
    private BottomNavigationView bottomMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        MainAdapter mainAdapter=new MainAdapter(getSupportFragmentManager());
        vpMain.setAdapter(mainAdapter);
        vpMain.setOffscreenPageLimit(3);//

    }

    private void initView() {
        relaMain = (RelativeLayout) findViewById(R.id.rela_main);
        vpMain = (ViewPager) findViewById(R.id.vp_main);
        vpMain.addOnPageChangeListener(this);

        bottomMain = (BottomNavigationView) findViewById(R.id.bottom_main);
        bottomMain.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_main:
                vpMain.setCurrentItem(0,false);
                break;
            case R.id.menu_notify:
                vpMain.setCurrentItem(1,false);

                break;
            case R.id.menu_more:
                vpMain.setCurrentItem(2,false);

                break;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottomMain.getMenu().getItem(position).setChecked(true);


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
