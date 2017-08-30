package com.example.amicoli.myvideo.utils;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.beans.BannerBean;
import com.youth.banner.loader.ImageLoader;

import static android.content.ContentValues.TAG;

/**
 * Created by Amicoli on 2017/4/18.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class LiveBannerImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Log.e(TAG, "displayImage======: "+((BannerBean)path).getImg());
        Glide.with(context.getApplicationContext())
                .load(((BannerBean)path).getImg())
                .crossFade()
                .placeholder(R.drawable.bili_default_image_tv)//站位
                .error(R.drawable.img_tips_error_banner_tv)//错误
                .into(imageView);
    }
}
