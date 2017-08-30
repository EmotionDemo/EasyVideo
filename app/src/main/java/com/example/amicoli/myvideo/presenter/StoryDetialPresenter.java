package com.example.amicoli.myvideo.presenter;

import android.util.Log;

import com.example.amicoli.myvideo.activies.StoryDetialActivity;
import com.example.amicoli.myvideo.beans.daily.StoriesBean;
import com.example.amicoli.myvideo.beans.daily.StoryDetailBean;
import com.example.amicoli.myvideo.iview.IStoryDetialView;
import com.example.amicoli.myvideo.network.ApiQueryBuilder;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import rx.Subscriber;

/**
 * Created by Amicoli on 2017/5/22.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class StoryDetialPresenter extends MvpBasePresenter<IStoryDetialView> {

    public void getStoryDeticalContent(String id){
        final IStoryDetialView storyDetialView = getView();
        if (storyDetialView != null){
            Subscriber<String> storyDetailBeanSubscriber = new Subscriber<String>() {
                @Override
                public void onCompleted() {
                    storyDetialView.showSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    storyDetialView.showError();
                }

                @Override
                public void onNext(String s) {
                    Log.e("sssss=", s);

                    storyDetialView.showCssView(s);
                }
            };
            ApiQueryBuilder.getInstance().getStoryContent(id,storyDetailBeanSubscriber);
        }
    }
}
