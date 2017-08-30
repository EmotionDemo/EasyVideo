package com.example.amicoli.myvideo.beans;

/**
 * Created by Amicoli on 2017/4/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class EntranceIconsBean {
    /**
     * id : 9
     * name : 绘画专区
     * entrance_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/big/xxhdpi/9_big.png?201704051400","height":"132","width":"132"}
     */

    private int id;
    private String name;
    private EntranceIconBean entrance_icon;

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

    public EntranceIconBean getEntrance_icon() {
        return entrance_icon;
    }

    public void setEntrance_icon(EntranceIconBean entrance_icon) {
        this.entrance_icon = entrance_icon;
    }

    @Override
    public String toString() {
        return "EntranceIconsBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", entrance_icon=" + entrance_icon +
                '}';
    }
}
