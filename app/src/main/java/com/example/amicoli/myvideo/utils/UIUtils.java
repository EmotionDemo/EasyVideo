package com.example.amicoli.myvideo.utils;

import android.app.Activity;

import com.example.amicoli.myvideo.R;
import com.tapadoo.alerter.Alerter;


/**
 * Created by ShineYang on 2017/4/6.
 */

public class UIUtils {
    public static void showFloatingAlert(Activity activity, String text) {
        Alerter.create(activity)
                .setText(text)
                .setBackgroundColor(R.color.grey900)
                .setIcon(R.mipmap.ic_no_internet)
                .show();
    }
}
