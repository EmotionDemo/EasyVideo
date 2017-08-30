package com.example.amicoli.myvideo.adapters;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.utils.AppUtils;

import java.util.List;

/**
 * Created by Amicoli on 2017/5/18.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class MainPageStoryAdapter extends BaseSectionQuickAdapter<SectionItem,BaseViewHolder>{
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public MainPageStoryAdapter(int layoutResId, int sectionHeadResId, List<SectionItem> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, SectionItem item) {
        helper.setText(R.id.tv_head_date, AppUtils.formatDate(0,item.header));
    }

    @Override
    protected void convert(BaseViewHolder helper, SectionItem item) {
        MainStoryItem mainStoryItem = (MainStoryItem)item.t;
        helper.setText(R.id.tv_rv_story_title,mainStoryItem.getTitle());
        Glide.with(mContext)
                .load(mainStoryItem.getImageResource()).crossFade()
                .placeholder(R.drawable.rv_image_placeholder)
                .into((ImageView)helper.getView(R.id.iv_rv_story_image));

    }
}
