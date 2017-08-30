package com.example.amicoli.myvideo.iview;

import com.example.amicoli.myvideo.beans.daily.StoryDetailBean;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Amicoli on 2017/5/22.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public interface IStoryDetialView extends MvpView {
    //void showStoryView(StoryDetailBean storyDetailBean);
    void showCssView(String s);
    void showError();
    void showSuccess();

}
