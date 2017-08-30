package com.example.amicoli.myvideo.activies;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.bumptech.glide.Glide;
import com.dl7.player.media.IjkPlayerView;
import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.beans.LiveContnetBean;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LivePlayActivity extends AppCompatActivity {

    @BindView(R.id.player_view)
    IjkPlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_play);
        ButterKnife.bind(this);
        LiveContnetBean live_play_info = (LiveContnetBean) getIntent().getSerializableExtra("content");
        initLiveInfo(live_play_info);
    }

    private void initLiveInfo(LiveContnetBean live_play_info) {
        Glide.with(this)
                .load(live_play_info.getContentSrc()).fitCenter().into(playerView.mPlayerThumb);//播放前显示的界面
        playerView.init()
                .setTitle(live_play_info.getContentName()+"的直播间")// title全屏时显示
                .alwaysFullScreen()//固定全屏
                .enableDanmaku()//运行重力翻转
                .setVideoPath(live_play_info.getPlayurl())//设置播放路径
                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)//指定初始视频
                .enableDanmaku()  //使用弹幕功能
                .setDanmakuSource(getResources().openRawResource(R.raw.danmu)) //添加弹幕库，在enableDanmaku()开启状态下
                .start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        playerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        playerView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        playerView.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        playerView.configurationChanged(newConfig);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (playerView.handleVolumeKey(keyCode)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (playerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }
}
