package com.example.amicoli.myvideo.iview;

import com.example.amicoli.myvideo.beans.BannerBean;
import com.example.amicoli.myvideo.beans.BiliBiliBean;
import com.example.amicoli.myvideo.beans.LivesBean;
import com.example.amicoli.myvideo.beans.PartitionBean;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

/**
 * Created by Amicoli on 2017/4/16.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public interface MainInfoView extends MvpView{
    void setBiliBiliBean(BiliBiliBean biliBiliBean);
//    void setLiveBean(List<LivesBean> liveBean);
//    void setBannerBean(List<BannerBean> bannerBean);
    void setdisSwiperefresh();
    void setRefreshSuccess();
    void setRefreshError();
}
