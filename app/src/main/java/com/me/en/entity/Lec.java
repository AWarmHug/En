package com.me.en.entity;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/11
 * 简介:
 */

public class Lec {


    /**
     * id : 53
     * title : 为热爱而生
     * cover : http://static.yixi.tv/background/2015-01-08/a5e5427b7aab409ec8ea0885c7d4af05.640x360.jpg
     * type : lec
     * time : 2013-05-18
     * created_at : 2015-04-07 15:31:36
     * lecturer : {"id":173,"nickname":"钱海英","desc":"钱海英，班夫山地电影节中国区负责人，英涛思华创始人。班夫山地电影节是全球最著名的户外运动电影节。同时，它还是一个纪录影片电影节和独立电影节，于1976年诞生于美丽的加拿大班夫山地文化中心。","pic":"http://static.yixi.tv/portrait/2015-01-05/2418cd2f7ef4a19294687c8e56d4f7d1.160x160.jpg"}
     */

    private int id;
    private String title;
    private String cover;
    private String type;
    private String time;
    private String created_at;
    private Lecr lecturer;

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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Lecr getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecr lecturer) {
        this.lecturer = lecturer;
    }

}
