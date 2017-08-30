package com.example.amicoli.myvideo.presenter;

import android.util.Log;

import com.example.amicoli.myvideo.beans.movie.LivePlayInfoBean;
import com.example.amicoli.myvideo.iview.IPlayInfoView;
import com.example.amicoli.myvideo.network.movie_live.MovieApiQueryBuilder;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import rx.Subscriber;

/**
 * Created by Amicoli on 2017/6/2.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class LiveMoviePlayInfoPresenter extends MvpBasePresenter<IPlayInfoView> {
    public void getPlayInfo(String paraString,boolean paraBoolean){
        final IPlayInfoView iPlayInfoView = getView();
        if (iPlayInfoView!=null){
            Subscriber<LivePlayInfoBean>subscriber = new Subscriber<LivePlayInfoBean>() {
                @Override
                public void onCompleted() {
                    iPlayInfoView.showSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    iPlayInfoView.showError();
                }

                @Override
                public void onNext(LivePlayInfoBean livePlayInfoBean) {
                    iPlayInfoView.setplayInfo(livePlayInfoBean);
                }
            };
            MovieApiQueryBuilder.getInstance().getLivePlayInfo(paraString,paraBoolean,subscriber);
        }

    }
}
