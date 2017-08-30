package com.example.amicoli.myvideo.iview;

import com.example.amicoli.myvideo.beans.movie.LivePlayInfoBean;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Amicoli on 2017/6/2.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public interface IPlayInfoView extends MvpView {
    void setplayInfo(LivePlayInfoBean livePlayInfoBean);
    void showError();

    void showSuccess();
}
