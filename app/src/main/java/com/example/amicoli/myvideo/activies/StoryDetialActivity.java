package com.example.amicoli.myvideo.activies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.iview.IStoryDetialView;
import com.example.amicoli.myvideo.presenter.StoryDetialPresenter;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;

public class StoryDetialActivity extends MvpActivity<IStoryDetialView, StoryDetialPresenter> implements IStoryDetialView, BGASwipeBackHelper.Delegate {

    @BindView(R.id.webView)
    WebView webView;

    private String story_id;
    protected BGASwipeBackHelper mSwipeBackHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initSwipeBackFinish();
        super.onCreate(savedInstanceState);
        setFullScreen();
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            story_id = getIntent().getStringExtra("story_id");
            getPresenter().getStoryDeticalContent(story_id);
        }
    }

    private void setFullScreen() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_stort_detial);
    }


    @Override
    public StoryDetialPresenter createPresenter() {
        return new StoryDetialPresenter();
    }

    @Override
    public void showCssView(String s) {
        //加载asset中的css
        webView.loadDataWithBaseURL("file:///android_asset/", s, "text/html", "UTF-8", null);
    }

    @Override
    public void showError() {
        showFailToast();
    }

    private void showFailToast() {
        Toast.makeText(this, "获取失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess() {
        showSuccessToast();
    }

    private void showSuccessToast() {
        Toast.makeText(this, "获取成功", Toast.LENGTH_SHORT).show();
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
        //Utils.showToast(this, msg, Toast.LENGTH_SHORT);
    }


}
