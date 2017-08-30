package com.example.amicoli.myvideo.beans.movie;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Amicoli on 2017/5/28.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class LiveMovieBean implements Serializable {
    private List<BodyBean> body;
    private int code;
    private String message;

    public List<BodyBean> getBody()
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

    public void setBody(List<BodyBean> paramList)
    {
        this.body = paramList;
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
        private String doubanId;
        private String img;
        private String lastUpdateTime;
        private String movieId;
        private String movieTypeName;
        private String name;
        private int publishTime;
        private double score;
        private String status;
        private String topicId;

        public String getDoubanId()
        {
            return this.doubanId;
        }

        public String getImg()
        {
            return this.img;
        }

        public String getLastUpdateTime()
        {
            return this.lastUpdateTime;
        }

        public String getMovieId()
        {
            return this.movieId;
        }

        public String getMovieTypeName()
        {
            return this.movieTypeName;
        }

        public String getName()
        {
            return this.name;
        }

        public int getPublishTime()
        {
            return this.publishTime;
        }

        public double getScore()
        {
            return this.score;
        }

        public String getStatus()
        {
            return this.status;
        }

        public String getTopicId()
        {
            return this.topicId;
        }

        public boolean isAlbum()
        {
            return this.album;
        }

        public void setAlbum(boolean paramBoolean)
        {
            this.album = paramBoolean;
        }

        public void setDoubanId(String paramString)
        {
            this.doubanId = paramString;
        }

        public void setImg(String paramString)
        {
            this.img = paramString;
        }

        public void setLastUpdateTime(String paramString)
        {
            this.lastUpdateTime = paramString;
        }

        public void setMovieId(String paramString)
        {
            this.movieId = paramString;
        }

        public void setMovieTypeName(String paramString)
        {
            this.movieTypeName = paramString;
        }

        public void setName(String paramString)
        {
            this.name = paramString;
        }

        public void setPublishTime(int paramInt)
        {
            this.publishTime = paramInt;
        }

        public void setScore(double paramDouble)
        {
            this.score = paramDouble;
        }

        public void setStatus(String paramString)
        {
            this.status = paramString;
        }

        public void setTopicId(String paramString)
        {
            this.topicId = paramString;
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "album=" + album +
                    ", doubanId='" + doubanId + '\'' +
                    ", img='" + img + '\'' +
                    ", lastUpdateTime='" + lastUpdateTime + '\'' +
                    ", movieId='" + movieId + '\'' +
                    ", movieTypeName='" + movieTypeName + '\'' +
                    ", name='" + name + '\'' +
                    ", publishTime=" + publishTime +
                    ", score=" + score +
                    ", status='" + status + '\'' +
                    ", topicId='" + topicId + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LiveMovieBean{" +
                "body=" + body +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
