package com.me.en.core.yixi.presenter;

import com.me.en.base.Listener;
import com.me.en.core.yixi.model.CommentsModelImpl;
import com.me.en.core.yixi.view.CommentsView;
import com.me.en.entity.Comment;
import com.me.en.entity.Error;

import java.util.List;

/**
 * Created by warm on 17/5/8.
 */

public class CommentsPresenter {

    private CommentsView commentsView;
    private CommentsModelImpl commentsModel;


    public CommentsPresenter(CommentsView commentsView) {
        this.commentsView = commentsView;
        this.commentsModel=new CommentsModelImpl();
    }

    public void getComments(int id,int page){
        commentsModel.getComments(id, page, new Listener<List<Comment>>() {
            @Override
            public void success(List<Comment> comments) {
                commentsView.getCommentsSuccess(comments);
            }

            @Override
            public void fail(Error e) {

            }
        });

    }

}
