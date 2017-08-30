package com.example.amicoli.myvideo.network.movie_live;


import com.example.amicoli.myvideo.beans.movie.LiveIndexbean;
import com.example.amicoli.myvideo.beans.movie.LiveMovieBean;
import com.example.amicoli.myvideo.beans.movie.LivePlayInfoBean;
import com.example.amicoli.myvideo.beans.movie.MovieData;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Amicoli on 2017/5/28.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class MovieApiQueryBuilder {
    public static final String DAILY_BASE_URL = "http://43.241.224.161";
    private static final int DEFAULT_TIMEOUT = 10;
    private static ILiveClient iLiveClient;

    private MovieApiQueryBuilder(){
        //设置默认超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(DAILY_BASE_URL)
                .build();
        iLiveClient = retrofit.create(ILiveClient.class);
    }

    public static MovieApiQueryBuilder getInstance() {
        return MovieApiQueryBuilder.SingletonHolder.INSTANCE;
    }

    //在访问QueryBuilder时创建单例
    private static class SingletonHolder {
        private static final MovieApiQueryBuilder INSTANCE = new MovieApiQueryBuilder();
    }
    /*
    * 获取电影列表
    * */
    public void getLiveIndexData(int paramInt1, int paramInt2, Subscriber<MovieData> subscriber){
        iLiveClient.getIndex(paramInt1,paramInt2)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    /**
     * 获取详细视频播放信息
     * */
    public void getLivePlayInfo(String paraString1, boolean paramBoolean, Subscriber<LivePlayInfoBean>subscriber){
        iLiveClient.getPlayInfo(paraString1,paramBoolean)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    /**
     * 获取分类列表更多影视
     * */
    public void getLiveIndexMore(int paramIn1,int paramInt2,String paramString,Subscriber<ResponseBody> subscriber){
        iLiveClient.getIndexMore(paramIn1,paramInt2,paramString)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    /**
     *上拉加载更多
     * */
    //public void getIndexMoreFor

}
