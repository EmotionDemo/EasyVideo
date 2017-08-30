package com.example.amicoli.myvideo.adapters;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.beans.movie.LiveIndexbean;
import com.example.amicoli.myvideo.widget.StarBarView;

import java.util.List;

/**
 * Created by Amicoli on 2017/5/29.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class LiveMovieAdapter extends BaseMultiItemQuickAdapter<LiveIndexbean,BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public LiveMovieAdapter(List<LiveIndexbean> data) {
        super(data);
        addItemType(0, R.layout.item_movie_header);
        addItemType(1,R.layout.item_rv_movie);
    }

    @Override
    protected void convert(BaseViewHolder helper, LiveIndexbean item) {
        switch (item.getItemType()){
            default:
                return;
            case 0:
                helper.setText(R.id.tv_movie_type,item.getTitleName());
                return;
            case 1:
                Glide.with(mContext)
                        .load(item.getImg())
                        .crossFade()
                        .placeholder(R.drawable.new_gril3)
                        .into((ImageView)helper.getView(R.id.iv_movie_pho));
                helper.setText(R.id.tv_content_title,item.getName());
                ((StarBarView)helper.getView(R.id.sbv_starbar)).setStarRating((float) (item.getScore()/2.0F));
                helper.setText(R.id.tv_store,String.valueOf(item.getScore()));
        }
    }
}
