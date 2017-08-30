package com.example.amicoli.myvideo.beans;

import java.io.Serializable;

/**
 * Created by Amicoli on 2017/4/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class BannerBean implements Serializable{
    /**
     * title : 四国活动，本周谁将获胜？
     * img : http://i0.hdslb.com/bfs/live/3cfdee35b1c57ecec3527eeab6d951aa16aa77d1.jpg
     * remark : 四国活动
     * link : http://live.bilibili.com/AppBanner/index?id=491
     */

    private String title;
    private String img;
    private String remark;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "BannerBean{" +
                "title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", remark='" + remark + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}

