package com.me.en.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;

import com.me.en.R;
import com.me.en.core.yixi.adapter.LecturerRvAdapter;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/11
 * 简介:
 */

public class SearchView extends LinearLayout {

    private EditText et;
    private ImageButton ib;

    private OnSearchClickListener onSearchClickListener;

    public void setOnSearchClickListener(OnSearchClickListener onSearchClickListener) {
        this.onSearchClickListener = onSearchClickListener;
    }

    public SearchView(Context context) {
        this(context,null);
    }

    public SearchView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        View.inflate(context, R.layout.view_search,this);

        et= (EditText) findViewById(R.id.et_content);

        ib= (ImageButton) findViewById(R.id.ib_search);

        ib.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSearchClickListener!=null){
                    onSearchClickListener.onClick(v,et.getText());
                }

            }
        });
    }



    public void OnSearchButton(OnClickListener onClickListener){
        ib.setOnClickListener(onClickListener);
    }

    public void onTextChange(TextWatcher watcher){
        et.addTextChangedListener(watcher);
    }


    public interface OnSearchClickListener {

        void onClick(View v,CharSequence sequence);

    }


}
