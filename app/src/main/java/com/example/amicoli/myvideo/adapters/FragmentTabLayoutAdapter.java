package com.example.amicoli.myvideo.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Amicoli on 2017/4/16.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class FragmentTabLayoutAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> fragments;
    private String[] titles;

    public FragmentTabLayoutAdapter(FragmentManager fm, Context context, List<Fragment> fragments, String[] titles) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments != null){
            return fragments.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if(fragments.size() == titles.length){
            return fragments.size();
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        //标题
        if (fragments.size() == titles.length){
            return titles[position];
        }
        return null;
    }
}
