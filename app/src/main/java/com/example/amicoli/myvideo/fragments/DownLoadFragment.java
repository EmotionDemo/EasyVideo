package com.example.amicoli.myvideo.fragments;


import android.os.Bundle;
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


public class DownLoadFragment extends Fragment {


    @BindView(R.id.tab_load)
    TabLayout tabLoad;
    @BindView(R.id.viewpager_load)
    ViewPager viewpagerLoad;

    private String[] tittles;
    private List<Fragment> fragments_films = new ArrayList<>();

    public DownLoadFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_down_load, container, false);
        ButterKnife.bind(this, view);
        initViews();
        initTablayout();
        return view;
    }
    //初始化Tablayout + viewPager控件
    private void initTablayout() {
        FragmentTabLayoutAdapter fragmentTabLayoutAdapter = new FragmentTabLayoutAdapter(getChildFragmentManager(), getContext(), fragments_films, tittles);
        viewpagerLoad.setAdapter(fragmentTabLayoutAdapter);
        tabLoad.setupWithViewPager(viewpagerLoad);
    }
    //初始化views
    private void initViews() {
        tittles = getResources().getStringArray(R.array.downfragment);
        fragments_films.add(new NewFilmFragment());
        fragments_films.add(new MainLandFragment());
        fragments_films.add(new EuroueFilmFragment());
        fragments_films.add(new RiHanFilmFragment());
    }

}
