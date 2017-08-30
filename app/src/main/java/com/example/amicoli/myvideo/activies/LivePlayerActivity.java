package com.example.amicoli.myvideo.activies;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.beans.movie.LiveIndexbean;
import com.example.amicoli.myvideo.beans.movie.LiveMovieBean;
import com.example.amicoli.myvideo.beans.movie.LivePlayInfoBean;
import com.example.amicoli.myvideo.iview.IPlayInfoView;
import com.example.amicoli.myvideo.presenter.LiveMoviePlayInfoPresenter;
import com.example.amicoli.myvideo.utils.PrefUtils;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class LivePlayerActivity extends MvpActivity<IPlayInfoView, LiveMoviePlayInfoPresenter> implements BGASwipeBackHelper.Delegate, IPlayInfoView {

    protected BGASwipeBackHelper mSwipeBackHelper;
    @BindView(R.id.videoplayer)
    JCVideoPlayerStandard videoplayer;
    @BindView(R.id.progress)
    ContentLoadingProgressBar progress;
    @BindView(R.id.player_fragment)
    FrameLayout playerFragment;
    private LiveIndexbean liveindexbean;
    private LiveMovieBean.BodyBean moviesbean;
    private String play_url , play_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_player);
        ButterKnife.bind(this);
        initSwipeBackFinish();
        LiveIndexbean liveIndexbean = (LiveIndexbean) getIntent().getSerializableExtra("IndexData");
        //Serializable localSerizable = getIntent().getSerializableExtra("MoviesData");
        if (liveIndexbean != null)
        getPresenter().getPlayInfo(String.valueOf(liveIndexbean.getMovieId()),liveIndexbean.isAlbum());
        //JCVideoPlayerStandard standard = videoplayer;

    }

    @NonNull
    @Override
    public LiveMoviePlayInfoPresenter createPresenter() {
        return new LiveMoviePlayInfoPresenter();
    }

    /**
     * 初始化滑动返回。在 super.onCreate(savedInstanceState) 之前调用该方法
     */
    private void initSwipeBackFinish() {
        mSwipeBackHelper = new BGASwipeBackHelper(this, this);

        // 「必须在 Application 的 onCreate 方法中执行 BGASwipeBackManager.getInstance().init(this) 来初始化滑动返回」
        // 下面几项可以不配置，这里只是为了讲述接口用法。

        // 设置滑动返回是否可用。默认值为 true
        mSwipeBackHelper.setSwipeBackEnable(true);
        // 设置是否仅仅跟踪左侧边缘的滑动返回。默认值为 true
        mSwipeBackHelper.setIsOnlyTrackingLeftEdge(true);
        // 设置是否是微信滑动返回样式。默认值为 true
        mSwipeBackHelper.setIsWeChatStyle(false);
        // 设置阴影资源 id。默认值为 R.drawable.bga_sbl_shadow
        mSwipeBackHelper.setShadowResId(R.drawable.bga_sbl_shadow);
        // 设置是否显示滑动返回的阴影效果。默认值为 true
        mSwipeBackHelper.setIsNeedShowShadow(true);
        // 设置阴影区域的透明度是否根据滑动的距离渐变。默认值为 true
        mSwipeBackHelper.setIsShadowAlphaGradient(true);
    }

    /**
     * 是否支持滑动返回。这里在父类中默认返回 true 来支持滑动返回，如果某个界面不想支持滑动返回则重写该方法返回 false 即可
     */
    @Override
    public boolean isSupportSwipeBack() {
        return true;
    }

    /**
     * 正在滑动返回
     *
     * @param slideOffset 从 0 到 1
     */
    @Override
    public void onSwipeBackLayoutSlide(float slideOffset) {
    }

    /**
     * 没达到滑动返回的阈值，取消滑动返回动作，回到默认状态
     */
    @Override
    public void onSwipeBackLayoutCancel() {
    }

    /**
     * 滑动返回执行完毕，销毁当前 Activity
     */
    @Override
    public void onSwipeBackLayoutExecuted() {
        mSwipeBackHelper.swipeBackward();
    }

    /**
     * Toast
     */
    protected void showToast(String msg) {

    }

    @Override
    public void setplayInfo(LivePlayInfoBean livePlayInfoBean) {
        Glide.with(getApplicationContext())
                .load(livePlayInfoBean.getBody().getImg()+"@!640_360")
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .placeholder(R.drawable.bili_default_image_tv)
                .into(videoplayer.thumbImageView);
        play_url = livePlayInfoBean.getBody().getVideos().get(0).getPlayerUrl();
        play_name = livePlayInfoBean.getBody().getVideos().get(0).getVideoName();

        videoplayer.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoplayer.setUp(play_url, JCVideoPlayer.SCREEN_LAYOUT_NORMAL,play_name);
                //使用外置播放器
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse(play_url);
                intent.setDataAndType(uri,"video/*");
                startActivity(intent);
            }
        });

//                    intent.setDataAndType(Uri.parse(play_url),"video/*");
//        videoplayer.startButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                videoplayer.startWindowTiny();
//            }
//        });
//        if (!PrefUtils.getFromPrefsBool("save_player_disanfang")){
//            JCVideoPlayerStandard jcVideoPlayerStandard = videoplayer;
//            Object [] arratOfObject = new Object[1];
//            arratOfObject[0] = play_name;
//            jcVideoPlayerStandard.setUp(play_url,0,arratOfObject);
//            videoplayer.startButton.performClick();
//        }
//        videoplayer.startButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(PrefUtils.getFromPrefsBool("save_player_disanfang")){
//                    JCVideoPlayerStandard standard = videoplayer;
//                    standard.setUp(play_url,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,play_name);
//                    Toast.makeText(LivePlayerActivity.this, "正在打开本地设备...", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent("android.intent.action.VIEW");
//                    intent.setDataAndType(Uri.parse(play_url),"video/*");
//                    startActivity(intent);
//                }
//            }
//        });

        progress.hide();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "请求错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess() {
        Toast.makeText(this, "请求成功", Toast.LENGTH_SHORT).show();
    }
}
