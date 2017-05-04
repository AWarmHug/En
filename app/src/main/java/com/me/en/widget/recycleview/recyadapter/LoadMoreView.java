package com.me.en.widget.recycleview.recyadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.me.en.R;


/**
 * 作者: 51hs_android
 * 时间: 2017/4/11
 * 简介:
 */

public class LoadMoreView {

    private View content;

    private TextView tv;
    private ProgressBar pb;


    public LoadMoreView(ViewGroup parent) {
        content = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_load_more, parent, false);
        tv= (TextView) content.findViewById(R.id.tv);
        tv.setText("正在加载，请稍后！");
        pb= (ProgressBar) content.findViewById(R.id.pb);
    }

    public View getContent() {
        return content;
    }

    public void setText(CharSequence text) {
        tv.setText(text);
    }

    public void setPbVisibility(int v){
        pb.setVisibility(v);


    }
}
