package com.example.amicoli.myvideo.RecommendBanner;

import java.util.List;

/**
 * Created by Amicoli on 2017/4/22.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class RecommendBanner {

    /**
     * code : 0
     * data : [{"title":"游戏0422","value":"http://www.bilibili.com/blackboard/activity-r1RRr70ae.html","image":"http://i0.hdslb.com/bfs/archive/fdc33b06d8fe0f462e3be0c70ecd9e4a352f11c8.jpg","type":2,"weight":1,"remark":"","hash":"ef875a560ee89691ee3d515efaa2d116"},{"title":"弹幕3","value":"http://www.bilibili.com/blackboard/activity-bhyszmj-m.html","image":"http://i0.hdslb.com/bfs/archive/ffde8736357104685aaaa3e9dab31129932d9fd4.jpg","type":2,"weight":2,"remark":"","hash":"66ac56b6899359583c166838157f9f03"},{"title":"舞蹈53期","value":"http://www.bilibili.com/blackboard/activity-BkLGq-LAg.html","image":"http://i0.hdslb.com/bfs/archive/056c95c221086a6ac1bbf4c5eaf39509be7336b4.png","type":2,"weight":3,"remark":"","hash":"490b9916b5b00e6313b09b04b6606678"},{"title":"联通","value":"http://www.bilibili.com/blackboard/activity-unicomopenbeta-m2.html","image":"http://i0.hdslb.com/bfs/archive/0b3bd8e7545c4ff76b54e8b6a092be1d42442930.png","type":2,"weight":5,"remark":"","hash":"c140b7b4b868e7f19609b860aa8b573c"}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

}
