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
import com.me.en.core.yixi.view.AlbumFragment;


public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity111";
    private RelativeLayout relaMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        getSupportFragmentManager().beginTransaction().add(R.id.frame, AlbumFragment.newInstance()).commit();

    }

    private void initView() {
        relaMain = (RelativeLayout) findViewById(R.id.rela_main);

    }


}
