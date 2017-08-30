package com.example.amicoli.myvideo;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import com.example.amicoli.myvideo.activies.MainActivity;
import com.zxy.recovery.core.Recovery;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager;

/**
 * Created by Amicoli on 2017/4/16.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 * effecct:
 */

public class MyApp extends Application {
    //屏幕高度
    public static int heightPixels;
    //全局context1
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        heightPixels = dm.heightPixels;
        this.context = getApplicationContext();
        BGASwipeBackManager.getInstance().init(this);
    }
    //全局Content
    public static Context getContext() {
        return context;
    }
}
