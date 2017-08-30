package com.example.amicoli.myvideo.presenter;

import android.util.Log;

import com.example.amicoli.myvideo.beans.BannerBean;
import com.example.amicoli.myvideo.beans.BiliBiliBean;
import com.example.amicoli.myvideo.beans.EntranceIconBean;
import com.example.amicoli.myvideo.beans.LivesBean;
import com.example.amicoli.myvideo.beans.PartitionBean;
import com.example.amicoli.myvideo.iview.MainInfoView;
import com.example.amicoli.myvideo.network.GitClient;
import com.example.amicoli.myvideo.network.GitRetrofit;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Amicoli on 2017/4/16.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class MainPresenter extends MvpBasePresenter<MainInfoView>{
    private BiliBiliBean biliBiliBean;
    public void setLiveInfo(){
        biliBiliBean = null;
        final MainInfoView view = getView();
        if(view != null){
            GitRetrofit retrofit = new GitRetrofit();
            GitClient client = retrofit.getGitClient();
            Call<BiliBiliBean> call = client.getLiveInfo("android","android","xxhdpi");
            call.enqueue(new Callback<BiliBiliBean>() {
                @Override
                public void onResponse(Response<BiliBiliBean> response, Retrofit retrofit) {
                    biliBiliBean = response.body();
                    view.setBiliBiliBean(biliBiliBean);
                    view.setdisSwiperefresh();
                    view.setRefreshSuccess();
                }
                @Override
                public void onFailure(Throwable t) {
                    view.setdisSwiperefresh();
                    view.setRefreshError();
                }
            });
        }
    }
}
