package com.me.en.entity;

/**
 * Created by warm on 17/5/8.
 */

public class Comment {
    /**
     * id : 4799
     * user_id : 115732
     * to_id : 0
     * content : 方向是环保，非常值得肯定。但是看这篇演讲真的很想打断她，随口的中国，台湾总统，不说台湾腔的事情，这些称谓从一个台湾学者口中说出不知道大家什么感受，反正我是打心底排斥她。
     * lecture_id : 416
     * created_at : 2017-03-01 20:50:50
     * updated_at : 2017-03-01 20:50:50
     * user : {"id":115732,"nickname":"oooo0oooo0@vip.qq.com","pic":"","is_lecturer":0}
     * touser : null
     * lecture : {"id":416,"title":"浊水溪三百年","type":"lec"}
     */

    private int id;
    private int user_id;
    private int to_id;
    private String content;
    private int lecture_id;
    private String created_at;
    private String updated_at;
    private UserBean user;
    private Object touser;
    private LectureBean lecture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTo_id() {
        return to_id;
    }

    public void setTo_id(int to_id) {
        this.to_id = to_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public Object getTouser() {
        return touser;
    }

    public void setTouser(Object touser) {
        this.touser = touser;
    }

    public LectureBean getLecture() {
        return lecture;
    }

    public void setLecture(LectureBean lecture) {
        this.lecture = lecture;
    }

    public static class UserBean {
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

    public static class LectureBean {
        /**
         * id : 416
         * title : 浊水溪三百年
         * type : lec
         */

        private int id;
        private String title;
        private String type;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
