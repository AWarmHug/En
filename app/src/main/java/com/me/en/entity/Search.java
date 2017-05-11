package com.me.en.entity;

import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/11
 * 简介:
 */

public class Search {

    private List<Lec> lecs;


    private List<Lecturer> lecturers;

    public List<Lec> getLecs() {
        return lecs;
    }

    public void setLecs(List<Lec> lecs) {
        this.lecs = lecs;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }
}
