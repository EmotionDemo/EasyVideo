package com.example.amicoli.myvideo.beans;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

/**
 * Created by Amicoli on 2017/4/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class EntranceIconBean implements MultiItemEntity,Serializable {
    /**
     * src : http://static.hdslb.com/live-static/images/mobile/android/big/xxhdpi/9_big.png?201704051400
     * height : 132
     * width : 132
     */

    private String src;
    private String height;
    private String width;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "EntranceIconBean{" +
                "src='" + src + '\'' +
                ", height='" + height + '\'' +
                ", width='" + width + '\'' +
                '}';
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
