package com.example.amicoli.myvideo.adapters;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.beans.LiveContnetBean;
import com.example.amicoli.myvideo.beans.PartitionsBean;
import com.example.amicoli.myvideo.utils.NumberUtil;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by Amicoli on 2017/4/16.
 * author 李丰华
 * qq:739574055
 * effect:for Live data to append
 * sina:wallamico
 */

public class MyLiveMultipleQuickAdapter extends BaseMultiItemQuickAdapter<LiveContnetBean,BaseViewHolder>{
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MyLiveMultipleQuickAdapter(List<LiveContnetBean> data) {
        super(data);
        /**
         * 根据相对应的静态值设置相应的布局
         * */
        addItemType(LiveContnetBean.TITLE, R.layout.item_live_header);
        addItemType(LiveContnetBean.CONTNET,R.layout.item_live_content);
        addItemType(LiveContnetBean.MORE,R.layout.item_live_more);
    }

    @Override
    protected void convert(BaseViewHolder helper, LiveContnetBean item) {
        switch (helper.getItemViewType()) { //根据相应的id值，对不同的View执行不同的操作
            case PartitionsBean.TITLE:
                helper.setText(R.id.tv_huihuazhuanqu, item.getTitleName());
                Glide.with(mContext).load(item.getTitleSrc()).crossFade().into((ImageView) helper.getView(R.id.titleIcon));
                helper.setText(R.id.count, NumberUtil.getNumWan(item.getCount()));
                break;
            case PartitionsBean.CONTNET:
                helper.addOnClickListener(R.id.contnet_item_main);
                helper.setText(R.id.tv_userName, item.getContentName());
                Glide.with(mContext).load(item.getContentSrc())
                        .crossFade()//淡入效果
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)//缓存
                        .placeholder(R.drawable.bili_default_image_tv)//占位符
                        .error(R.drawable.img_tips_error_banner_tv)//错误
                        .into((ImageView) helper.getView(R.id.iv_imgface));
                helper.setText(R.id.tv_title, item.getTitle());
                helper.setText(R.id.guankancount, String.valueOf(item.getOnline()));
                break;
            case 0:
                break;
        }
    }

}
