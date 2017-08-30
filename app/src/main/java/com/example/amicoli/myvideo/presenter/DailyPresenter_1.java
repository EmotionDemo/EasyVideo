package com.example.amicoli.myvideo.presenter;

import com.example.amicoli.myvideo.adapters.MainStoryItem;
import com.example.amicoli.myvideo.adapters.SectionItem;
import com.example.amicoli.myvideo.beans.daily.DailyBean;
import com.example.amicoli.myvideo.beans.daily.StoriesBean;
import com.example.amicoli.myvideo.beans.daily.TopBanners;
import com.example.amicoli.myvideo.beans.daily.TopStoriesBean;
import com.example.amicoli.myvideo.iview.IDailyView_1;
import com.example.amicoli.myvideo.network.ApiQueryBuilder;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Amicoli on 2017/5/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class DailyPresenter_1 extends MvpBasePresenter<IDailyView_1>{

    public void fetData(final Boolean isRefreshing){
        final IDailyView_1 iDailyView_1 = getView();

        if (iDailyView_1!=null){
            Subscriber<DailyBean>subscriber = new Subscriber<DailyBean>() {
                @Override
                public void onCompleted() {
                    iDailyView_1.refreshSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    if (isRefreshing){
                        iDailyView_1.setRefreshFailed();
                        iDailyView_1.setStopRefresh();
                    }else {
                        iDailyView_1.showFailed();
                    }
                }

                @Override
                public void onNext(DailyBean dailyBean) {
                    String date = dailyBean.getDate();
                    List<TopStoriesBean> bannerList;
                    List<StoriesBean> storyList;
                    List<SectionItem> sectionItems = new ArrayList<>();
                    List<String> imageUrls = new ArrayList<>();
                    List<String> titles = new ArrayList<>();
                   // List<String> header footer设置
                    List<String> idList = new ArrayList<>();
                    TopBanners banners = new TopBanners();

                    //TopStoriesBean banners = new TopStoriesBean();
                    bannerList = dailyBean.getTop_stories();
                    storyList = dailyBean.getStories();
                    for (TopStoriesBean bannerStoty : bannerList){
                        imageUrls.add(bannerStoty.getImage());
                        titles.add(bannerStoty.getTitle());
                        idList.add(bannerStoty.getId());
                    }//设置banner信息
                    banners.setImages(imageUrls);
                    banners.setTitles(titles);
                    banners.setIdList(idList);

                    //设置主页信息
                    for(StoriesBean storiesBean : storyList){
                        MainStoryItem item = new MainStoryItem();
                        item.setTitle(storiesBean.getTitle());
                        item.setImageResource(storiesBean.getImages()[0]);
                        item.setId(storiesBean.getId());
                        sectionItems.add(new SectionItem(item));
                    }
                    if (isRefreshing){
                        iDailyView_1.setDaily(dailyBean);
                        iDailyView_1.setDailyData_1(date,banners,sectionItems);
                        iDailyView_1.setStopRefresh();

                    }else
                        iDailyView_1.showMainPageStoryContent(date,banners,sectionItems);
                }
            };
            ApiQueryBuilder.getInstance().getLatestStories(subscriber);//获取单例
        }
    }

    public  void getBeforeData(String date){
        final IDailyView_1 iDailyView_1 = getView();
        if (iDailyView_1 != null){
            Subscriber<DailyBean> subscriber = new Subscriber<DailyBean>() {
                @Override
                public void onCompleted() {
                    //发送完成
                }

                @Override
                public void onError(Throwable e) {
                    iDailyView_1.showLoadMoreFailed();
                }

                @Override
                public void onNext(DailyBean dailyBean) {
                    String date = dailyBean.getDate();
                    List<StoriesBean> storiesBeanList;
                    storiesBeanList = dailyBean.getStories();
                    //日期header

                    List<SectionItem> sectionItems = new ArrayList<>();
                    sectionItems.add(new SectionItem(true ,date));
                    for (StoriesBean storiesBean:storiesBeanList){
                        MainStoryItem item = new MainStoryItem();
                        item.setTitle(storiesBean.getTitle());
                        item.setId(storiesBean.getId());
                        item.setImageResource(storiesBean.getImages()[0]);
                        sectionItems.add(new SectionItem(item));
                    }
                    iDailyView_1.loadMore(date,sectionItems);
                }
            };
            ApiQueryBuilder.getInstance().getBeforedailyStories(date,subscriber);
        }
    }
}
