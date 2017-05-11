package com.me.en.core.yixi.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.me.en.R;
import com.me.en.base.fragment.BaseFragment;
import com.me.en.core.yixi.adapter.LectureRvAdapter;
import com.me.en.entity.Base;
import com.me.en.entity.Lec;
import com.me.en.entity.Search;
import com.me.en.net.RetrofitHelper;
import com.me.en.net.api.YixiApi;
import com.me.en.widget.SearchView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/11
 * 简介:
 */

public class SearchFragment extends BaseFragment implements SearchView.OnSearchClickListener {
    private SearchView sv;
    private Toolbar tb;
    private LinearLayout ll;


    public static SearchFragment newInstance() {

        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_search;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        tb = (Toolbar) view.findViewById(R.id.tb);
        tb.setNavigationIcon(R.drawable.ic_vec_back);
        sv = (SearchView) view.findViewById(R.id.sv);
        sv.getEt().setHint("请输入...");


        ll = (LinearLayout) view.findViewById(R.id.ll);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RetrofitHelper.getApi(YixiApi.class).getKeyWords()
                .flatMapIterable(new Function<Base<List<String>>, Iterable<String>>() {
                    @Override
                    public Iterable<String> apply(@NonNull Base<List<String>> listBase) throws Exception {
                        return listBase.getData();
                    }
                })
                .map(new Function<String, TextView>() {
                    @Override
                    public TextView apply(@NonNull String s) throws Exception {
                        TextView tv = new TextView(getContext());
                        tv.setText(s);
                        return tv;
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TextView>() {
                    @Override
                    public void accept(@NonNull TextView textView) throws Exception {
                        ll.addView(textView);
                    }
                });
        sv.setOnSearchClickListener(this);
    }

    @Override
    public void onClick(View v, CharSequence sequence) {

        RetrofitHelper.getApi(YixiApi.class).getSearch(sequence.toString())
                .filter(new Predicate<Base<Search>>() {
                    @Override
                    public boolean test(@NonNull Base<Search> searchBase) throws Exception {
                        return searchBase.getRes()==0;
                    }
                })
                .map(new Function<Base<Search>, Search>() {
                    @Override
                    public Search apply(@NonNull Base<Search> searchBase) throws Exception {
                        return searchBase.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Search>() {
                    @Override
                    public void accept(@NonNull Search searchBase) throws Exception {
                        ll.removeAllViews();

                        if (searchBase.getLecturers()!=null&&searchBase.getLecturers().size()>0){
                            //演讲人

                        }


                        if(searchBase.getLecs()!=null&&searchBase.getLecs().size()>0){
                            //演讲
                            TextView tv=new TextView(getContext());
                            tv.setText("相关演讲");
                            tv.setGravity(Gravity.CENTER_HORIZONTAL);
                            Drawable drawable= ResourcesCompat.getDrawable(getResources(),R.drawable.ic_vec_line,null);
                            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//必须设置图片大小，否则不显示
                            tv.setCompoundDrawables(null,null,null,drawable);
                            for (Lec lec : searchBase.getLecs()) {
                                ll.addView(showItem(lec));
                            }


                        }

                    }
                });
    }

    private View showItem(Lec lec){
        LectureRvAdapter.NewViewHolder viewHolder=new LectureRvAdapter.NewViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.recy_adapter_lecture_list,ll,false));
        viewHolder.tv_title.setText(lec.getTitle());
        viewHolder.tv_lecture_time_site.setText(lec.getTime());
        viewHolder.tv_viewnum.setVisibility(View.GONE);
        viewHolder.tv_lecturer_name.setText(lec.getLecturer().getNickname());
        Glide.with(getContext()).load(lec.getCover()).crossFade().centerCrop().into(viewHolder.iv_cover);
        return viewHolder.itemView;
    }



}
