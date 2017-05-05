package com.me.en.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by warm on 17/5/4.
 */

public class Lecture implements Parcelable {


    private int id;
    private String title;
    private String desc;
    private int lecturer_id;
    private String viewnum;
    private String likenum;
    private String cmtnum;
    private String purecontent;
    private String cover;
    private String background;
    private String video;
    private int cate_id;
    private String type;
    private int published;
    private String site;
    private String time;
    private String created_at;
    private Lecturer lecturer;
    private Category category;
    private List<Tag> tags;

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

    public int getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(int lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    public String getViewnum() {
        return viewnum;
    }

    public void setViewnum(String viewnum) {
        this.viewnum = viewnum;
    }

    public String getLikenum() {
        return likenum;
    }

    public void setLikenum(String likenum) {
        this.likenum = likenum;
    }

    public String getPurecontent() {
        return purecontent;
    }

    public void setPurecontent(String purecontent) {
        this.purecontent = purecontent;
    }

    public String getCmtnum() {
        return cmtnum;
    }

    public void setCmtnum(String cmtnum) {
        this.cmtnum = cmtnum;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
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

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    public Lecture() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.desc);
        dest.writeInt(this.lecturer_id);
        dest.writeString(this.viewnum);
        dest.writeString(this.likenum);
        dest.writeString(this.cmtnum);
        dest.writeString(this.purecontent);
        dest.writeString(this.cover);
        dest.writeString(this.background);
        dest.writeString(this.video);
        dest.writeInt(this.cate_id);
        dest.writeString(this.type);
        dest.writeInt(this.published);
        dest.writeString(this.site);
        dest.writeString(this.time);
        dest.writeString(this.created_at);
        dest.writeParcelable(this.lecturer, flags);
        dest.writeParcelable(this.category, flags);
        dest.writeTypedList(this.tags);
    }

    protected Lecture(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.desc = in.readString();
        this.lecturer_id = in.readInt();
        this.viewnum = in.readString();
        this.likenum = in.readString();
        this.cmtnum = in.readString();
        this.purecontent = in.readString();
        this.cover = in.readString();
        this.background = in.readString();
        this.video = in.readString();
        this.cate_id = in.readInt();
        this.type = in.readString();
        this.published = in.readInt();
        this.site = in.readString();
        this.time = in.readString();
        this.created_at = in.readString();
        this.lecturer = in.readParcelable(Lecturer.class.getClassLoader());
        this.category = in.readParcelable(Category.class.getClassLoader());
        this.tags = in.createTypedArrayList(Tag.CREATOR);
    }

    public static final Creator<Lecture> CREATOR = new Creator<Lecture>() {
        @Override
        public Lecture createFromParcel(Parcel source) {
            return new Lecture(source);
        }

        @Override
        public Lecture[] newArray(int size) {
            return new Lecture[size];
        }
    };
}