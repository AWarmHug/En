package com.me.en.entity;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/8
 * 简介:用户
 */

public class User {
    /**
     * id : 115732
     * nickname : oooo0oooo0@vip.qq.com
     * pic :
     * is_lecturer : 0
     */

    private int id;
    private String nickname;
    private String pic;
    private int is_lecturer;

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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getIs_lecturer() {
        return is_lecturer;
    }

    public void setIs_lecturer(int is_lecturer) {
        this.is_lecturer = is_lecturer;
    }
}
