package com.example.amicoli.myvideo.iview;

import com.example.amicoli.myvideo.beans.movie.LiveIndexbean;
import com.example.amicoli.myvideo.beans.movie.MovieData;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

/**
 * Created by Amicoli on 2017/6/6.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public interface ILiveIndexMore extends MvpView {
    //void getMoreData(MovieData movieData);

    void getIndexMoreList(List<LiveIndexbean> movieData);

    void setRefreshError();

    void setdisSwiperefresh();

    void showFailed();

    void showSuccess();

   //void loadMore(List<LiveIndexbean> movieData);
   // void getIndex2MoreList(List<LiveIndexbean> movieDataMore);

    //void getLiveIndexDataMore(List<LiveIndexbean> paramList);
}
