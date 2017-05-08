package com.me.en.entity;

import java.util.List;

/**
 * Created by warm on 17/5/4.
 */

public class Album {


    private int id;
    private String title;
    private String desc;
    private String webcontent;
    private String background;
    private String purecontent;
    private String newpc;
    private int published;
    private int sort;
    private String created_at;
    private List<Lecture> lectures;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getWebcontent() {
        return webcontent;
    }

    public void setWebcontent(String webcontent) {
        this.webcontent = webcontent;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getPurecontent() {
        return purecontent;
    }

    public void setPurecontent(String purecontent) {
        this.purecontent = purecontent;
    }

    public String getNewpc() {
        return newpc;
    }

    public void setNewpc(String newpc) {
        this.newpc = newpc;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }
}
