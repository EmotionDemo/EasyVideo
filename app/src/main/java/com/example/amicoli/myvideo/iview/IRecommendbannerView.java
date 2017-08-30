package com.example.amicoli.myvideo.iview;

import com.example.amicoli.myvideo.beans.RecommendBannerBean;
import com.example.amicoli.myvideo.beans.recommendbeans.BannerBean;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

/**
 * Created by Amicoli on 2017/5/11.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public interface IRecommendbannerView extends MvpView{
    void getDataReponse(BannerBean bannerBean);
    void getDataFailure(Throwable e);
}
