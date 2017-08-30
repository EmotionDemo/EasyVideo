package com.example.amicoli.myvideo.beans;

import java.util.List;

/**
 * Created by Amicoli on 2017/4/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class DataBean {
    private List<BannerBean> banner;
    private List<EntranceIconsBean> entranceIcons;
    private List<PartitionsBean> partitions;

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public List<EntranceIconsBean> getEntranceIcons() {
        return entranceIcons;
    }

    public void setEntranceIcons(List<EntranceIconsBean> entranceIcons) {
        this.entranceIcons = entranceIcons;
    }

    public List<PartitionsBean> getPartitions() {
        return partitions;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "banner=" + banner +
                ", entranceIcons=" + entranceIcons +
                ", partitions=" + partitions +
                '}';
    }

    public void setPartitions(List<PartitionsBean> partitions) {

        this.partitions = partitions;
    }
}
