package com.me.en.core.yixi.presenter;

import com.me.en.base.Listener;
import com.me.en.core.yixi.model.AlbumModelImpl;
import com.me.en.core.yixi.view.AlbumView;
import com.me.en.entity.Error;
import com.me.en.entity.AlbumBean;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/3
 * 简介:
 */

public class AlbumPresenter {

    private AlbumView albumView;
    private AlbumModelImpl selectModel;

    public AlbumPresenter(AlbumView albumView) {
        this.albumView = albumView;
        this.selectModel=new AlbumModelImpl();

    }


    public void getSelect(){
        selectModel.getSelect(new Listener<AlbumBean>() {
            @Override
            public void success(AlbumBean albumBean) {
                albumView.getSelectSuccess(albumBean);
            }

            @Override
            public void fail(Error e) {
                albumView.getSelectFail(e);
            }
        });
    }

}
