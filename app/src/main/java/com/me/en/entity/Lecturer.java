package com.me.en.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

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

    private List<LecturesWithCover> lectures_with_cover;

    public List<LecturesWithCover> getLectures_with_cover() {
        return lectures_with_cover;
    }

    public void setLectures_with_cover(List<LecturesWithCover> lectures_with_cover) {
        this.lectures_with_cover = lectures_with_cover;
    }

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

     private static class LecturesWithCover implements Parcelable {

        private int id;
        private String title;
        private int lecturer_id;
        private String cover;


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

        public int getLecturer_id() {
            return lecturer_id;
        }

        public void setLecturer_id(int lecturer_id) {
            this.lecturer_id = lecturer_id;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.title);
            dest.writeInt(this.lecturer_id);
            dest.writeString(this.cover);
        }

        public LecturesWithCover() {
        }

        protected LecturesWithCover(Parcel in) {
            this.id = in.readInt();
            this.title = in.readString();
            this.lecturer_id = in.readInt();
            this.cover = in.readString();
        }

        public static final Creator<LecturesWithCover> CREATOR = new Creator<LecturesWithCover>() {
            @Override
            public LecturesWithCover createFromParcel(Parcel source) {
                return new LecturesWithCover(source);
            }

            @Override
            public LecturesWithCover[] newArray(int size) {
                return new LecturesWithCover[size];
            }
        };
    }


    public Lecturer() {
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
        dest.writeList(this.lectures_with_cover);
    }

    protected Lecturer(Parcel in) {
        this.id = in.readInt();
        this.nickname = in.readString();
        this.desc = in.readString();
        this.pic = in.readString();
        this.background = in.readString();
        this.is_lecturer = in.readInt();
        this.cate_id = in.readInt();
        this.lectures_with_cover = new ArrayList<LecturesWithCover>();
        in.readList(this.lectures_with_cover, LecturesWithCover.class.getClassLoader());
    }

    public static final Creator<Lecturer> CREATOR = new Creator<Lecturer>() {
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