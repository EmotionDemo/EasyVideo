package com.example.amicoli.myvideo.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.view.View;

/**
 * Created by Amicoli on 2017/4/13.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class CacheUtils {
    public static boolean getbBoolean(Context context,String key){
        /**
         * 缓存值
         * */
        SharedPreferences sharedPreferences = context.getSharedPreferences("amicoli",Context.MODE_PRIVATE);
        boolean aBoolean = sharedPreferences.getBoolean(key,false);
        return aBoolean;
    }

    /**
     * 保存软件参数
     * */
    public static void putBoolean(Context context, String key,boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("amicoli",Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key,value).commit();
    }
}
