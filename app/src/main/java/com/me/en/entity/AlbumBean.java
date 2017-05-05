package com.me.en.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/5/2
 * 简介:
 */

public class AlbumBean {

    private int res;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    private List<DataBean> data;


    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {


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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.title);
            dest.writeString(this.desc);
            dest.writeString(this.webcontent);
            dest.writeString(this.background);
            dest.writeString(this.purecontent);
            dest.writeString(this.newpc);
            dest.writeInt(this.published);
            dest.writeInt(this.sort);
            dest.writeString(this.created_at);
            dest.writeList(this.lectures);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.id = in.readInt();
            this.title = in.readString();
            this.desc = in.readString();
            this.webcontent = in.readString();
            this.background = in.readString();
            this.purecontent = in.readString();
            this.newpc = in.readString();
            this.published = in.readInt();
            this.sort = in.readInt();
            this.created_at = in.readString();
            this.lectures = new ArrayList<Lecture>();
            in.readList(this.lectures, Lecture.class.getClassLoader());
        }

        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }
}
