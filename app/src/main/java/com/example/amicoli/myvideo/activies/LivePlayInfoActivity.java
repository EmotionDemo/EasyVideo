package com.example.amicoli.myvideo.activies;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.beans.CollapsingToolbarLayoutState;
import com.example.amicoli.myvideo.beans.LiveContnetBean;
import com.example.amicoli.myvideo.fragments.PlayInfoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LivePlayInfoActivity extends BaseActivity {

    @BindView(R.id.imageview)
    ImageView imageview;
    @BindView(R.id.playButton)
    ButtonBarLayout playButton;
    @BindView(R.id.toolbar_play)
    Toolbar toolbarPlay;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.player_fragment)
    FrameLayout playerFragment;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    private CollapsingToolbarLayoutState state;
    private LiveContnetBean liveContnetBean_play_info;
    private FragmentTransaction fragmentTransaction;
    private PlayInfoFragment fragmentPlayInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_play_info);
        ButterKnife.bind(this);
        liveContnetBean_play_info = (LiveContnetBean) getIntent().getSerializableExtra("content");
        initState();
        addLiveData();
        initBottomOperaBar();
    }

    private void addLiveData() {
        Glide.with(this)
                .load(liveContnetBean_play_info.getContentSrc())
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .placeholder(R.drawable.ic_next_video_placeholder)
                .error(R.drawable.img_tips_error_banner_tv)
                .into(imageview);
    }

    private void initBottomOperaBar() {
        fragmentPlayInfo = new PlayInfoFragment();
        FragmentManager manager = getSupportFragmentManager();
        fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.player_fragment, fragmentPlayInfo);
        fragmentTransaction.commit();
    }

    private void initState() {
        toolbarPlay.setTitle("");
        setSupportActionBar(toolbarPlay);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//设置返回键可用
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        final AppBarLayout app_bar = (AppBarLayout) findViewById(R.id.app_bar);
        app_bar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (verticalOffset == 0) {
                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
                        state = CollapsingToolbarLayoutState.EXPANDED;//修改状态标记为展开
//                        collapsingToolbarLayout.setTitle("展开");//设置title为EXPANDED
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                        toolbarPlay.setTitle("");//设置title不显示
                        playButton.setVisibility(View.VISIBLE);//隐藏播放按钮
                        state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠
                    }
                } else {
                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                        if (state == CollapsingToolbarLayoutState.COLLAPSED) {
                            playButton.setVisibility(View.GONE);//由折叠变为中间状态时隐藏播放按钮
                        }
//                        collapsingToolbarLayout.setTitle("中间状态");//设置title为INTERNEDIATE
                        state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
                    }
                }
            }
        });
        //展开
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appBar.setExpanded(true);
                //延时，等展开动画结束
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(700);//休眠3秒
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        goPlayer();
                    }
                }.start();
                //跳转到播放页面

            }
        });

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到播放页面
                goPlayer();
            }
        });
    }

    private void goPlayer() {
        Intent intent = new Intent(this, LivePlayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("content", liveContnetBean_play_info);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    /**
     * 左上角返回监听
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
