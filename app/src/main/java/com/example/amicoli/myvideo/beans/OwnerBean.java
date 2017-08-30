package com.example.amicoli.myvideo.beans;

/**
 * Created by Amicoli on 2017/4/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class OwnerBean {
    /**
     * face : http://i0.hdslb.com/bfs/face/3d23ca395683fcfcdfa9421583eadb8196d3ed56.jpg
     * mid : 1348074
     * name : 译水
     */

    private String face;
    private int mid; //投搞人ID
    private String name;

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OwnerBean{" +
                "face='" + face + '\'' +
                ", mid=" + mid +
                ", name='" + name + '\'' +
                '}';
    }
}
