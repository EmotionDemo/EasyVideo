package com.example.amicoli.myvideo.network;


import com.example.amicoli.myvideo.beans.BiliBiliBean;
import com.example.amicoli.myvideo.beans.daily.DailyBean;
import com.example.amicoli.myvideo.beans.daily.StoryDetailBean;
import com.example.amicoli.myvideo.beans.recommendbeans.BannerBean;



import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit2.http.Path;
import rx.Observable;



/**
 * Created by Amicoli on 2017/4/16.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public interface GitClient {
    /*直播页面*/
    @GET("AppNewIndex/common")
    Call<BiliBiliBean> getLiveInfo(@Query("_device") String _device,
                                   @Query("platform") String platform,
                                   @Query("scale") String scale);

    /*推荐页面的*/
    @retrofit2.http.GET("x/v2/show")
    Observable<BannerBean> getRecommendBanner(@Query("build") String build,
                                              @Query("platform") String platform);

    //最新内容
    @retrofit2.http.GET("4/news/latest")
    Observable<DailyBean> getLatestStories();

    //前日新闻
    @retrofit2.http.GET("4/news/before/{date}")
    Observable<DailyBean> getBeforeDailyStories(@Path("date") String date);

    //日报详情
    @retrofit2.http.GET("4/news/{Id}")
    Observable<StoryDetailBean> getStoryContent(@Path("Id") String Id);
}
