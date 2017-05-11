package com.me.en.entity;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/11
 * 简介:演讲人 简要信息
 */

public class Lecr {

    /**
     * id : 173
     * nickname : 钱海英
     * desc : 钱海英，班夫山地电影节中国区负责人，英涛思华创始人。班夫山地电影节是全球最著名的户外运动电影节。同时，它还是一个纪录影片电影节和独立电影节，于1976年诞生于美丽的加拿大班夫山地文化中心。
     * pic : http://static.yixi.tv/portrait/2015-01-05/2418cd2f7ef4a19294687c8e56d4f7d1.160x160.jpg
     */

    private int id;
    private String nickname;
    private String desc;
    private String pic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

}
