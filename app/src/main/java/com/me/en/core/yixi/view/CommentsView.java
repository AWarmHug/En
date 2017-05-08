package com.me.en.core.yixi.view;

import com.me.en.entity.Comment;

import java.util.List;

/**
 * Created by warm on 17/5/8.
 */

public interface CommentsView {

    void getCommentsSuccess(List<Comment> comments);

}
