package com.example.amicoli.myvideo.utils;

import java.text.DecimalFormat;

/**
 * Created by Amicoli on 2017/4/16.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class NumberUtil {
    public static String getNumWan(int num) {
        if (num < 10000) {
            return String.valueOf(num);
        } else {
            double n = (double) num / 10000;
            DecimalFormat df = new DecimalFormat("#.0");
            return df.format(n) + "万";
        }
    }
}
