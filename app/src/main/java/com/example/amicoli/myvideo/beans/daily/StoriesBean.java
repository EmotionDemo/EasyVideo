package com.example.amicoli.myvideo.beans.daily;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Amicoli on 2017/5/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class StoriesBean implements Serializable {
    private String title;
    private String id;
    private String url;
    private String[] images;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
