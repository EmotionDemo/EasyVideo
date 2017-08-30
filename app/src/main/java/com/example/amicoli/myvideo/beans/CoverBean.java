package com.example.amicoli.myvideo.beans;

/**
 * Created by Amicoli on 2017/4/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class CoverBean {
    /**
     * src : http://i0.hdslb.com/bfs/live/c158ac31184e478347c7dd46c21db85aebab00c3.jpg
     * height : 180
     * width : 320
     */

    private String src;
    private int height;
    private int width;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "CoverBean{" +
                "src='" + src + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
