package com.example.amicoli.myvideo.iview;

import com.example.amicoli.myvideo.beans.movie.LiveIndexbean;
import com.example.amicoli.myvideo.beans.movie.LiveMovieBean;
import com.example.amicoli.myvideo.beans.movie.MovieData;
import com.hannesdorfmann.mosby.mvp.MvpView;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by Amicoli on 2017/5/28.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public interface IMovieLiveView extends MvpView {
    void setMovieData(MovieData movieData);
    void getSuccess();
    void getError();
    void setdisSwiperefresh();
    void setRefreshSuccess();
    void setRefreshError();
    void showFailed();
}
