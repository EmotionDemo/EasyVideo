package com.example.amicoli.myvideo.beans.movie;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Amicoli on 2017/5/28.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class LivePlayInfoBean implements Serializable {
    private BodyBean body;
    private int code;
    private String message;

    @Override
    public String toString() {
        return "LivePlayInfoBean{" +
                "body=" + body +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public BodyBean getBody()
    {
        return this.body;
    }

    public int getCode()
    {
        return this.code;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setBody(BodyBean paramBodyBean)
    {
        this.body = paramBodyBean;
    }

    public void setCode(int paramInt)
    {
        this.code = paramInt;
    }

    public void setMessage(String paramString)
    {
        this.message = paramString;
    }

    public static class BodyBean
            implements Serializable
    {
        private boolean album;
        private String desc;
        private String img;
        private String movieId;
        private String topicId;
        private List<VideosBean> videos;


        @Override
        public String toString() {
            return "BodyBean{" +
                    "album=" + album +
                    ", desc='" + desc + '\'' +
                    ", img='" + img + '\'' +
                    ", movieId='" + movieId + '\'' +
                    ", topicId='" + topicId + '\'' +
                    ", videos=" + videos +
                    '}';
        }

        public String getDesc()
        {
            return this.desc;
        }

        public String getImg()
        {
            return this.img;
        }

        public String getMovieId()
        {
            return this.movieId;
        }

        public String getTopicId()
        {
            return this.topicId;
        }

        public List<VideosBean> getVideos()
        {
            return this.videos;
        }

        public boolean isAlbum()
        {
            return this.album;
        }

        public void setAlbum(boolean paramBoolean)
        {
            this.album = paramBoolean;
        }

        public void setDesc(String paramString)
        {
            this.desc = paramString;
        }

        public void setImg(String paramString)
        {
            this.img = paramString;
        }

        public void setMovieId(String paramString)
        {
            this.movieId = paramString;
        }

        public void setTopicId(String paramString)
        {
            this.topicId = paramString;
        }

        public void setVideos(List<VideosBean> paramList)
        {
            this.videos = paramList;
        }

        public static class VideosBean
                implements Serializable
        {
            private int aid;
            private int index;
            private String infoUrl;
            private String playerUrl;
            private int vid;
            private String videoName;

            @Override
            public String toString() {
                return "VideosBean{" +
                        "aid=" + aid +
                        ", index=" + index +
                        ", infoUrl='" + infoUrl + '\'' +
                        ", playerUrl='" + playerUrl + '\'' +
                        ", vid=" + vid +
                        ", videoName='" + videoName + '\'' +
                        '}';
            }

            public int getAid()
            {
                return this.aid;
            }

            public int getIndex()
            {
                return this.index;
            }

            public String getInfoUrl()
            {
                return this.infoUrl;
            }

            public String getPlayerUrl()
            {
                return this.playerUrl;
            }

            public int getVid()
            {
                return this.vid;
            }

            public String getVideoName()
            {
                return this.videoName;
            }

            public void setAid(int paramInt)
            {
                this.aid = paramInt;
            }

            public void setIndex(int paramInt)
            {
                this.index = paramInt;
            }

            public void setInfoUrl(String paramString)
            {
                this.infoUrl = paramString;
            }

            public void setPlayerUrl(String paramString)
            {
                this.playerUrl = paramString;
            }

            public void setVid(int paramInt)
            {
                this.vid = paramInt;
            }

            public void setVideoName(String paramString)
            {
                this.videoName = paramString;
            }
        }
    }
}
