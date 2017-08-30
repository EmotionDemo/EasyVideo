package com.example.amicoli.myvideo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.iview.MainInfoView;
import com.example.amicoli.myvideo.presenter.MainPresenter;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecommendFragment extends MvpFragment<MainInfoView, MainPresenter> {

    @BindView(R.id.recommend_banner)
    Banner recommendBanner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public RecommendFragment() {
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}
