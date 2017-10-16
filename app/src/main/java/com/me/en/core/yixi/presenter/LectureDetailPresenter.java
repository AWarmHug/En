package com.me.en.core.yixi.presenter;

import com.me.en.base.Listener;
import com.me.en.core.yixi.model.LectureModelImpl;
import com.me.en.core.yixi.view.LectureDetailView;
import com.me.en.entity.Error;
import com.me.en.entity.Lecture;
import com.me.en.entity.Video;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/5
 * 简介:
 */

public class LectureDetailPresenter {

    private LectureDetailView lectureDetailView;
    private LectureModelImpl lectureModel;

    public LectureDetailPresenter(LectureDetailView lectureDetailView) {
        this.lectureDetailView = lectureDetailView;
        this.lectureModel=new LectureModelImpl();
    }

    public void getLecture(int id){
        lectureModel.getLecture(id, new Listener<Lecture>() {
            @Override
            public void success(Lecture lecture) {
                lectureDetailView.getLectureDetailSuccess(lecture);
                getRelated(lecture.getId());
            }

            @Override
            public void fail(Error e) {
                lectureDetailView.getLectureDetailFail(e);

            }
        });
    }

    public void getLecturePlay(int id,String playId){
        lectureModel.getLecturePlay(id,playId, new Listener<Video>() {
            @Override
            public void success(Video video) {
                lectureDetailView.getLecturePlaySuccess(video);

            }

            @Override
            public void fail(Error e) {
                lectureDetailView.getLecturePlayFail(e);


            }
        });
    }

    public void getRelated(int id){
        lectureModel.getRelated(id, new Listener<Lecture>() {
            @Override
            public void success(Lecture lecture) {
                lectureDetailView.getRelatedS(lecture);

            }

            @Override
            public void fail(Error e) {

            }
        });
    }

}
