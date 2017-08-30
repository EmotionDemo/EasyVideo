package com.example.amicoli.myvideo.beans.daily;

/**
 * Created by Amicoli on 2017/5/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class TopStoriesBean {
    /**
     * image : https://pic3.zhimg.com/v2-9fc5c3a7b05db66d029cd9809d020996.jpg
     * type : 0
     * id : 9425287
     * ga_prefix : 051714
     * title : 听着电视剧里的「皇上」「臣妾」「大人」，我有点不能忍
     */

    private String image;
    private int type;
    private String id;
    private String ga_prefix;
    private String title;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
