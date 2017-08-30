package com.example.amicoli.myvideo.activies;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.beans.movie.LivePlayInfoBean;
import com.example.amicoli.myvideo.iview.IPlayInfoView;
import com.example.amicoli.myvideo.presenter.LiveMoviePlayInfoPresenter;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

public class LiveMovieActivity extends MvpActivity<IPlayInfoView,LiveMoviePlayInfoPresenter> implements IPlayInfoView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_movie);
    }

    @NonNull
    @Override
    public LiveMoviePlayInfoPresenter createPresenter() {
        return new LiveMoviePlayInfoPresenter();
    }

    @Override
    public void setplayInfo(LivePlayInfoBean livePlayInfoBean) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showSuccess() {

    }
}
