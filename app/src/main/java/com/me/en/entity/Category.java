package com.me.en.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by warm on 17/5/4.
 */

public class Category implements Parcelable {
    /**
     * id : 5
     * name : 观察
     * sort : 2
     */

    private int id;
    private String name;
    private int sort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.sort);
    }

    public Category() {
    }

    protected Category(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.sort = in.readInt();
    }

    public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}