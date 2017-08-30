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


public class TopFragment extends Fragment {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private String[] titles;
    private List<Fragment> fragments = new ArrayList<>();

    public TopFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        ButterKnife.bind(this, view);
        addDatas();
        initTablayout();
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    /**
     * @author 李丰华
     * @effect 初始化tablayout
     * @date 2017/4/16
     */

    private void initTablayout() {
        FragmentTabLayoutAdapter fragmentTabLayoutAdapter = new FragmentTabLayoutAdapter(getChildFragmentManager(), getContext(), fragments, titles);
        viewpager.setAdapter(fragmentTabLayoutAdapter);
        tabLayout.setupWithViewPager(viewpager);
    }

    /**
     * @author 李丰华
     * @effect 初始化framment与相关数据
     * @date 2017/4/16
     */

    private void addDatas() {
        titles = getResources().getStringArray(R.array.topfragment);
        fragments.add(new LiveFragment());
        fragments.add(new MovieFragment());
        fragments.add(new RecommendFragment());
        fragments.add(new DailyStoryFragment());
        fragments.add(new DynamicFragment());
        fragments.add(new FoundFragment());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
