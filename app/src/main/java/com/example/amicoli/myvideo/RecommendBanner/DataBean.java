package com.example.amicoli.myvideo.RecommendBanner;

/**
 * Created by Amicoli on 2017/4/22.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class DataBean {
    /**
     * title : 游戏0422
     * value : http://www.bilibili.com/blackboard/activity-r1RRr70ae.html
     * image : http://i0.hdslb.com/bfs/archive/fdc33b06d8fe0f462e3be0c70ecd9e4a352f11c8.jpg
     * type : 2
     * weight : 1
     * remark :
     * hash : ef875a560ee89691ee3d515efaa2d116
     */

    private String title;
    private String value;
    private String image;
    private int type;
    private int weight;
    private String remark;
    private String hash;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
