package com.example.amicoli.myvideo.beans.movie;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

/**
 * Created by Amicoli on 2017/5/28.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class LiveIndexbean implements MultiItemEntity, Serializable {

    private boolean album;
    private String doubanId;
    private int id;
    private String img;
    private int index;
    private int movieId;
    private String name;
    private String pid;
    private double score;
    private boolean show;
    private String titleId;
    private String titleName;
    private String topicId;
    private int type;
    private boolean v3Show;

    public boolean isAlbum() {
        return album;
    }

    public void setAlbum(boolean album) {
        this.album = album;
    }

    public String getDoubanId() {
        return doubanId;
    }

    public void setDoubanId(String doubanId) {
        this.doubanId = doubanId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isV3Show() {
        return v3Show;
    }

    public void setV3Show(boolean v3Show) {
        this.v3Show = v3Show;
    }

    @Override
    public String toString() {
        return "LiveIndexbean{" +
                "album=" + album +
                ", doubanId='" + doubanId + '\'' +
                ", id=" + id +
                ", img='" + img + '\'' +
                ", index=" + index +
                ", movieId=" + movieId +
                ", name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                ", score=" + score +
                ", show=" + show +
                ", titleId='" + titleId + '\'' +
                ", titleName='" + titleName + '\'' +
                ", topicId='" + topicId + '\'' +
                ", type=" + type +
                ", v3Show=" + v3Show +
                '}';
    }

    @Override
    public int getItemType() {
        return this.type;
    }
}
