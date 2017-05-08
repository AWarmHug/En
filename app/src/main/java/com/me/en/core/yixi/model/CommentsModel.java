package com.me.en.core.yixi.model;

import com.me.en.base.Listener;
import com.me.en.entity.Comment;

import java.util.List;

/**
 * Created by warm on 17/5/8.
 */

public interface CommentsModel {
    void getComments(int id, int page, Listener<List<Comment>> listener);

}
