package com.me.en.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by warm on 17/5/5.
 */

public class Video {
    /**
     * video_id : XMjcyNDc4MTAwMA==
     * sid : 649399539600051c5f309
     * token : 5900
     * files : {"3gphd":{"duration":"2282.00","segs":[{"no":1,"size":"86759519","duration":2282,"url":"http://k.youku.com/player/getFlvPath/sid/649399539600051c5f309_01/st/mp4/fileid/030020010058FD1EB677D207383F55C4318961-A149-57D5-AFF6-3070C4619904?K=afb41f843fe507352412ff44&hd=0&ymovie=1&sign=a5ae62cf722f196060d02f9ad8ab40a7&ts=2282&ctype=51&token=5900&ev=1&oip=2021929295&ep=K04crBO5R7bWhl30cAa1kZdMjrIlCjVURvVG9Y8PHv98tod%2B8Q2NO%2FHHw8ncIrQwzTBo6qhcLmceeO1UIZ5gStxpvPDkXj4LFVsddZ8l4D4eENkmRszZRzDiKI4VPist"}]}}
     */

    private String video_id;
    private String sid;
    private int token;
    private FilesBean files;

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public FilesBean getFiles() {
        return files;
    }

    public void setFiles(FilesBean files) {
        this.files = files;
    }

    public static class FilesBean {
        /**
         * 3gphd : {"duration":"2282.00","segs":[{"no":1,"size":"86759519","duration":2282,"url":"http://k.youku.com/player/getFlvPath/sid/649399539600051c5f309_01/st/mp4/fileid/030020010058FD1EB677D207383F55C4318961-A149-57D5-AFF6-3070C4619904?K=afb41f843fe507352412ff44&hd=0&ymovie=1&sign=a5ae62cf722f196060d02f9ad8ab40a7&ts=2282&ctype=51&token=5900&ev=1&oip=2021929295&ep=K04crBO5R7bWhl30cAa1kZdMjrIlCjVURvVG9Y8PHv98tod%2B8Q2NO%2FHHw8ncIrQwzTBo6qhcLmceeO1UIZ5gStxpvPDkXj4LFVsddZ8l4D4eENkmRszZRzDiKI4VPist"}]}
         */

        @SerializedName("3gphd")
        private _$3gphdBean _$3gphd;

        public _$3gphdBean get_$3gphd() {
            return _$3gphd;
        }

        public void set_$3gphd(_$3gphdBean _$3gphd) {
            this._$3gphd = _$3gphd;
        }

        public static class _$3gphdBean {
            /**
             * duration : 2282.00
             * segs : [{"no":1,"size":"86759519","duration":2282,"url":"http://k.youku.com/player/getFlvPath/sid/649399539600051c5f309_01/st/mp4/fileid/030020010058FD1EB677D207383F55C4318961-A149-57D5-AFF6-3070C4619904?K=afb41f843fe507352412ff44&hd=0&ymovie=1&sign=a5ae62cf722f196060d02f9ad8ab40a7&ts=2282&ctype=51&token=5900&ev=1&oip=2021929295&ep=K04crBO5R7bWhl30cAa1kZdMjrIlCjVURvVG9Y8PHv98tod%2B8Q2NO%2FHHw8ncIrQwzTBo6qhcLmceeO1UIZ5gStxpvPDkXj4LFVsddZ8l4D4eENkmRszZRzDiKI4VPist"}]
             */

            private String duration;
            private List<SegsBean> segs;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public List<SegsBean> getSegs() {
                return segs;
            }

            public void setSegs(List<SegsBean> segs) {
                this.segs = segs;
            }

            public static class SegsBean {
                /**
                 * no : 1
                 * size : 86759519
                 * duration : 2282
                 * url : http://k.youku.com/player/getFlvPath/sid/649399539600051c5f309_01/st/mp4/fileid/030020010058FD1EB677D207383F55C4318961-A149-57D5-AFF6-3070C4619904?K=afb41f843fe507352412ff44&hd=0&ymovie=1&sign=a5ae62cf722f196060d02f9ad8ab40a7&ts=2282&ctype=51&token=5900&ev=1&oip=2021929295&ep=K04crBO5R7bWhl30cAa1kZdMjrIlCjVURvVG9Y8PHv98tod%2B8Q2NO%2FHHw8ncIrQwzTBo6qhcLmceeO1UIZ5gStxpvPDkXj4LFVsddZ8l4D4eENkmRszZRzDiKI4VPist
                 */

                private int no;
                private String size;
                private int duration;
                private String url;

                public int getNo() {
                    return no;
                }

                public void setNo(int no) {
                    this.no = no;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public int getDuration() {
                    return duration;
                }

                public void setDuration(int duration) {
                    this.duration = duration;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
