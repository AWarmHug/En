package com.me.en.core.yixi.presenter;

import com.me.en.base.Listener;
import com.me.en.core.yixi.model.LectureTypeModelImpl;
import com.me.en.core.yixi.view.LectureTypeView;
import com.me.en.entity.Error;
import com.me.en.entity.Lecture;

import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/9
 * 简介:
 */

public class LectureTypePresenter {
    private LectureTypeView lectureTypeView;
    private LectureTypeModelImpl lectureDateModel;

    public LectureTypePresenter(LectureTypeView lectureTypeView) {

        this.lectureTypeView = lectureTypeView;
        this.lectureDateModel=new LectureTypeModelImpl();
    }


    public void getLectureDate(String type,int page){
        lectureDateModel.getLectureByDate(type, page, new Listener<List<Lecture>>() {
            @Override
            public void success(List<Lecture> lectures) {
                lectureTypeView.getLectureTypeSuccess(lectures);

            }

            @Override
            public void fail(Error e) {

            }
        });
    }

}
