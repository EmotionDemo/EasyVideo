package com.example.amicoli.myvideo.adapters;

import com.chad.library.adapter.base.entity.SectionEntity;

import java.io.Serializable;

/**
 * Created by Amicoli on 2017/5/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class SectionItem extends SectionEntity implements Serializable{
    String dataString;
    String storyId;

    public SectionItem(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public SectionItem(MainStoryItem item) {
        super(item);
        this.storyId = item.getId();
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

}
