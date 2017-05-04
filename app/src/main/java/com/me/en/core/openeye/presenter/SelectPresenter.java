package com.me.en.core.openeye.presenter;

import com.me.en.base.Listener;
import com.me.en.core.openeye.model.SelectModelImpl;
import com.me.en.core.openeye.view.SelectView;
import com.me.en.entity.Error;
import com.me.en.entity.SelectBean;

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
        selectModel.getSelect(new Listener<SelectBean>() {
            @Override
            public void success(SelectBean selectBean) {
                selectView.getSelectSuccess(selectBean);
            }

            @Override
            public void fail(Error e) {
                selectView.getSelectFail(e);
            }
        });
    }

}
