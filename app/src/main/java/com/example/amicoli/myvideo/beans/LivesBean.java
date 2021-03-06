package com.example.amicoli.myvideo.beans;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Amicoli on 2017/4/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class LivesBean  {

    private OwnerBean owner;
    private CoverBean cover;
    private String title;
    private int room_id;
    private int check_version;
    private int online;
    private String area;
    private int area_id;
    private String playurl;
    private String accept_quality;
    private int broadcast_type;
    private int is_tv;

    public OwnerBean getOwner() {
        return owner;
    }

    public void setOwner(OwnerBean owner) {
        this.owner = owner;
    }

    public CoverBean getCover() {
        return cover;
    }

    public void setCover(CoverBean cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getCheck_version() {
        return check_version;
    }

    public void setCheck_version(int check_version) {
        this.check_version = check_version;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getPlayurl() {
        return playurl;
    }

    public void setPlayurl(String playurl) {
        this.playurl = playurl;
    }

    public String getAccept_quality() {
        return accept_quality;
    }

    public void setAccept_quality(String accept_quality) {
        this.accept_quality = accept_quality;
    }

    public int getBroadcast_type() {
        return broadcast_type;
    }

    public void setBroadcast_type(int broadcast_type) {
        this.broadcast_type = broadcast_type;
    }

    public int getIs_tv() {
        return is_tv;
    }

    public void setIs_tv(int is_tv) {
        this.is_tv = is_tv;
    }

    @Override
    public String toString() {
        return "LivesBean{" +
                "owner=" + owner +
                ", cover=" + cover +
                ", title='" + title + '\'' +
                ", room_id=" + room_id +
                ", check_version=" + check_version +
                ", online=" + online +
                ", area='" + area + '\'' +
                ", area_id=" + area_id +
                ", playurl='" + playurl + '\'' +
                ", accept_quality='" + accept_quality + '\'' +
                ", broadcast_type=" + broadcast_type +
                ", is_tv=" + is_tv +
                '}';
    }
}
