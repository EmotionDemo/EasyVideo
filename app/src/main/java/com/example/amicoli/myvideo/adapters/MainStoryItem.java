package com.example.amicoli.myvideo.adapters;

import java.util.List;

/**
 * Created by Amicoli on 2017/5/18.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class MainStoryItem {
    private String title;  //标题
    private Class<?> activity; //需要跳转的Activity
    private String imageResource;// 图片地址
    private String id; //id

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class<?> getActivity() {
        return activity;
    }

    public void setActivity(Class<?> activity) {
        this.activity = activity;
    }

    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
