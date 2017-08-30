package com.example.amicoli.myvideo.beans;

/**
 * Created by Amicoli on 2017/4/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class PartitionBean {
    /**
     * id : 9
     * name : 绘画专区
     * area : draw
     * sub_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/9.png?201704051400","height":"63","width":"63"}
     * count : 68
     */

    private int id;
    private String name;
    private String area;
    private SubIconBean sub_icon;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public SubIconBean getSub_icon() {
        return sub_icon;
    }

    public void setSub_icon(SubIconBean sub_icon) {
        this.sub_icon = sub_icon;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PartitionBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", sub_icon=" + sub_icon +
                ", count=" + count +
                '}';
    }
}
