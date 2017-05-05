package com.me.en.core;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.me.en.R;
import com.me.en.base.activity.BaseActivity;
import com.me.en.core.yixi.ui.AlbumFragment;


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
