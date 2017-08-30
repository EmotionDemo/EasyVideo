package com.example.amicoli.myvideo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.adapters.FragmentTabLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PlayInfoFragment extends Fragment {

    @BindView(R.id.tablayout_player)
    TabLayout tablayoutPlayer;
    @BindView(R.id.viewpager_player)
    ViewPager viewpagerPlayer;

    private String[] titles;
    private List<Fragment> fragments = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.player_info_fragment, container, false);
        ButterKnife.bind(this, v);
        initLiveFragmentInfo();
        FragmentTabLayoutAdapter fragmenttablayoutadapter = new FragmentTabLayoutAdapter(getChildFragmentManager(), getContext(), fragments, titles);
        viewpagerPlayer.setAdapter(fragmenttablayoutadapter);
        tablayoutPlayer.setupWithViewPager(viewpagerPlayer);
        return v;
    }

    private void initLiveFragmentInfo() {
        //标题
        titles = getResources().getStringArray(R.array.livePlayerTabLayout);
        //fragments
        fragments.add(new LiveInteractionFragment());
        fragments.add(new LiveRankingFragment());
        fragments.add(new LiveFleetFragment());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
