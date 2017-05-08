package com.me.en.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by warm on 17/5/4.
 * 演讲者
 */

public class Lecturer implements Parcelable {
    /**
     * id : 115430
     * nickname : 张素玢
     * desc : 台湾历史学者
     * pic : http://static.yixi.tv/portrait/2017-02-28/46fa17bd5c0af9b6c3969fd404d3a616.160x160.jpg
     * background : http://static.yixi.tv/background/2017-02-28/d6bc01b99b55bdbaeac05327789feeef.995x500.jpg
     * is_lecturer : 1
     * cate_id : 5
     */

    private int id;
    private String nickname;
    private String desc;
    private String pic;
    private String background;
    private int is_lecturer;
    private int cate_id;

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

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getIs_lecturer() {
        return is_lecturer;
    }

    public void setIs_lecturer(int is_lecturer) {
        this.is_lecturer = is_lecturer;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nickname);
        dest.writeString(this.desc);
        dest.writeString(this.pic);
        dest.writeString(this.background);
        dest.writeInt(this.is_lecturer);
        dest.writeInt(this.cate_id);
    }

    public Lecturer() {
    }

    protected Lecturer(Parcel in) {
        this.id = in.readInt();
        this.nickname = in.readString();
        this.desc = in.readString();
        this.pic = in.readString();
        this.background = in.readString();
        this.is_lecturer = in.readInt();
        this.cate_id = in.readInt();
    }

    public static final Parcelable.Creator<Lecturer> CREATOR = new Parcelable.Creator<Lecturer>() {
        @Override
        public Lecturer createFromParcel(Parcel source) {
            return new Lecturer(source);
        }

        @Override
        public Lecturer[] newArray(int size) {
            return new Lecturer[size];
        }
    };
}