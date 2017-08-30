package com.example.amicoli.myvideo.beans.recommendbeans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Amicoli on 2017/5/12.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class BodyBean {
    /**
     * title : 全职高手 第06集 剑圣
     * cover : http://i0.hdslb.com/bfs/archive/b2e34273011e8d068e775eec4e1c594b11b22ec5.jpg
     * uri : bilibili://video/10309064
     * param : 10309064
     * goto : av
     * play : 1170386
     * danmaku : 95148
     * rname : 国产动画
     * duration : 1420
     * name : 阅文漫镜头
     * is_ad : false
     * cm_mark : 0
     * request_id : 1494575034619q172a18a61a26q79
     * src_id : 1511
     * is_ad_loc : true
     * client_ip : 223.99.199.178
     */

    private String title;
    private String cover;
    private String uri;
    private String param;
    @SerializedName("goto")
    private String gotoX;
    private int play;
    private int danmaku;
    private String rname;
    private int duration;
    private String name;
    private boolean is_ad;
    private int cm_mark;
    private String request_id;
    private int src_id;
    private boolean is_ad_loc;
    private String client_ip;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getGotoX() {
        return gotoX;
    }

    public void setGotoX(String gotoX) {
        this.gotoX = gotoX;
    }

    public int getPlay() {
        return play;
    }

    public void setPlay(int play) {
        this.play = play;
    }

    public int getDanmaku() {
        return danmaku;
    }

    public void setDanmaku(int danmaku) {
        this.danmaku = danmaku;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_ad() {
        return is_ad;
    }

    public void setIs_ad(boolean is_ad) {
        this.is_ad = is_ad;
    }

    public int getCm_mark() {
        return cm_mark;
    }

    public void setCm_mark(int cm_mark) {
        this.cm_mark = cm_mark;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public int getSrc_id() {
        return src_id;
    }

    public void setSrc_id(int src_id) {
        this.src_id = src_id;
    }

    public boolean isIs_ad_loc() {
        return is_ad_loc;
    }

    public void setIs_ad_loc(boolean is_ad_loc) {
        this.is_ad_loc = is_ad_loc;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }
}
