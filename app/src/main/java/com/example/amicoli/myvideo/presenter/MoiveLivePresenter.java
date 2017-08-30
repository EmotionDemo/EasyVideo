package com.example.amicoli.myvideo.presenter;

import android.util.Log;

import com.example.amicoli.myvideo.beans.movie.LiveIndexbean;
import com.example.amicoli.myvideo.beans.movie.MovieData;
import com.example.amicoli.myvideo.iview.IMovieLiveView;
import com.example.amicoli.myvideo.network.movie_live.MovieApiQueryBuilder;
import com.google.gson.JsonObject;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by Amicoli on 2017/5/28.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class MoiveLivePresenter extends MvpBasePresenter <IMovieLiveView>{
    public void getLiveMovieList(int paramInt1,int paramInt2,final Boolean isRefreshing){
        final IMovieLiveView iMovieLiveView = getView();
        if (iMovieLiveView!=null){
            Subscriber<MovieData>subscriber = new Subscriber<MovieData>() {
                @Override
                public void onCompleted() {
                    iMovieLiveView.getSuccess();
                    iMovieLiveView.setRefreshSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    if (isRefreshing){
                        iMovieLiveView.setRefreshError();
                        iMovieLiveView.setdisSwiperefresh();
                    }else {
                        iMovieLiveView.showFailed();
                    }
                }

                @Override
                public void onNext(MovieData movieData) {
                    if (isRefreshing){
                        iMovieLiveView.setMovieData(movieData);
                        iMovieLiveView.setdisSwiperefresh();
                    }
                }
            };

            MovieApiQueryBuilder.getInstance().getLiveIndexData(paramInt1,paramInt2,subscriber);
        }
    }
}
