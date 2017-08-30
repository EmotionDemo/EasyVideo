package com.example.amicoli.myvideo.network;

import com.example.amicoli.myvideo.beans.daily.DailyBean;
import com.example.amicoli.myvideo.beans.daily.StoriesBean;
import com.example.amicoli.myvideo.beans.daily.StoryDetailBean;
import com.example.amicoli.myvideo.beans.recommendbeans.BannerBean;
import com.example.amicoli.myvideo.utils.HtmlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;



import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Amicoli on 2017/5/14.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class ApiQueryBuilder {
//    public static final String APP_BASE_URL = "http://app.bilibili.com/";
//
//    public static final String APP_LIVE_URL = "http://live.bilibili.com/";
//
//    //http://app.bilibili.com/x/v2/show?build=434000&platform=android
//    public static final String BASE_URL_RECOMMEND = "http://app.bilibili.com/";

    public static final String DAILY_BASE_URL = "http://news-at.zhihu.com/api/";

    private static final int DEFAULT_TIMEOUT = 10;

    private static GitClient gitClient;

    private ApiQueryBuilder(){
        //设置默认超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(DAILY_BASE_URL)
                .build();

        gitClient = retrofit.create(GitClient.class);
    }

    /**
     * 获取某日期前一天的日报内容
     * */
    public void getBeforedailyStories(String date, Subscriber<DailyBean> subscriber) {
        gitClient.getBeforeDailyStories(date)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    //在访问QueryBuilder时创建单例
    private static class SingletonHolder {
        private static final ApiQueryBuilder INSTANCE = new ApiQueryBuilder();
    }


    public static ApiQueryBuilder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 获取banner
    *@param
     *
    */
    public void getBanner(String build,String platform,Subscriber <BannerBean> subscriber){
        gitClient.getRecommendBanner(build,platform)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    /**
     * 获取最新消息
     * */
    public void getLatestStories(Subscriber<DailyBean> subscriber){
        gitClient.getLatestStories()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 根据对应id获取日报详细内容
     * */
    public void getStoryContent(String id, Subscriber<String> subscriber) {
        gitClient.getStoryContent(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<StoryDetailBean, String>() {
                    @Override
                    public String call(StoryDetailBean storyDetailBean) {
                        return HtmlUtils.structHtml(storyDetailBean);
                    }
                }).subscribe(subscriber);
    }

}
