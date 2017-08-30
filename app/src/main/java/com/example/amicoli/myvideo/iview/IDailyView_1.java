package com.example.amicoli.myvideo.iview;

import com.example.amicoli.myvideo.adapters.MainStoryItem;
import com.example.amicoli.myvideo.adapters.SectionItem;
import com.example.amicoli.myvideo.beans.daily.DailyBean;
import com.example.amicoli.myvideo.beans.daily.StoriesBean;
import com.example.amicoli.myvideo.beans.daily.TopBanners;
import com.example.amicoli.myvideo.beans.daily.TopStoriesBean;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amicoli on 2017/5/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public interface IDailyView_1 extends MvpView{
    void setDaily(DailyBean dailyBean);
    void setDailyData_1(String date, TopBanners topBanners, List<SectionItem> mainStoryItemListWithHeader);//设置主页内容信息
    void setRefreshFailed();
    void setStopRefresh();
    void showFailed();
    void refreshSuccess();
    void showMainPageStoryContent(String date, TopBanners bannerList, List<SectionItem> sectionItems);
    void showLoadMoreFailed();
    void loadMore(String date, List<SectionItem> sectionItems);


}
