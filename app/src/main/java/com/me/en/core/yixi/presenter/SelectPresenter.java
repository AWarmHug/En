package com.me.en.core.yixi.presenter;

import com.me.en.base.Listener;
import com.me.en.core.yixi.model.SelectModelImpl;
import com.me.en.core.yixi.view.SelectView;
import com.me.en.entity.Error;
import com.me.en.entity.AlbumBean;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/3
 * 简介:
 */

public class SelectPresenter {

    private SelectView selectView;
    private SelectModelImpl selectModel;

    public SelectPresenter(SelectView selectView) {
        this.selectView = selectView;
        this.selectModel=new SelectModelImpl();

    }


    public void getSelect(){
        selectModel.getSelect(new Listener<AlbumBean>() {
            @Override
            public void success(AlbumBean albumBean) {
                selectView.getSelectSuccess(albumBean);
            }

            @Override
            public void fail(Error e) {
                selectView.getSelectFail(e);
            }
        });
    }

}
