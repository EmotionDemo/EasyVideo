package com.example.amicoli.myvideo.activies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.adapters.LiveMovieAdapter;
import com.example.amicoli.myvideo.beans.movie.LiveIndexbean;

import com.example.amicoli.myvideo.iview.ILiveIndexMore;
import com.example.amicoli.myvideo.presenter.LiveIndexMorePresenter;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveIndexMoreActivity extends MvpActivity<ILiveIndexMore,LiveIndexMorePresenter>implements ILiveIndexMore,SwipeRefreshLayout.OnRefreshListener,BaseQuickAdapter.RequestLoadMoreListener{

    @BindView(R.id.liveindex_recyclerView)
    RecyclerView liveindexRecyclerView;
    @BindView(R.id.swipe_indexmore)
    SwipeRefreshLayout swipeIndexmore;
    private LiveIndexbean liveIndexbeandata;
    private LiveMovieAdapter livemoveadapter;
    private GridLayoutManager gridlayoutManager;
    private List<LiveIndexbean> liveindexbeen = new ArrayList<>();
    private boolean isRefreshing = false;
    private boolean isLoadMore =false;
    private int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_index_more);
        ButterKnife.bind(this);
        initSwip();
        initRecycler();
        liveIndexbeandata = ((LiveIndexbean) getIntent().getSerializableExtra("IndexData"));
        getPresenter().getIndexMoreData(1,10,liveIndexbeandata.getTitleId(),true);
        startPlayer();
    }

    @NonNull
    @Override
    public LiveIndexMorePresenter createPresenter() {
        return new LiveIndexMorePresenter();
    }

    public void initRecycler(){
        livemoveadapter = new LiveMovieAdapter(null);
        gridlayoutManager = new GridLayoutManager(this,3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        liveindexRecyclerView.setLayoutManager(gridlayoutManager);
        liveindexRecyclerView.setAdapter(livemoveadapter);
        livemoveadapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        livemoveadapter.setOnLoadMoreListener(this);
        isLoadMore = true;
    }

    private void initSwip() {
        swipeIndexmore.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swipeIndexmore.setSize(swipeIndexmore.DEFAULT);
        swipeIndexmore.setDistanceToTriggerSync(300);
        swipeIndexmore.setOnRefreshListener(this);
        swipeIndexmore.setProgressViewEndTarget(true,300);
        swipeIndexmore.post(new Runnable() {
            @Override
            public void run() {
                swipeIndexmore.setRefreshing(true);
            }
        });
    }

    public void startPlayer(){
        //跳转到当前movie item
        liveindexRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.live_movie_content:
                        LiveIndexbean liveIndexbean = (LiveIndexbean) adapter.getItem(position);
                        Intent intent = new Intent(LiveIndexMoreActivity.this,LivePlayerActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("IndexData",liveIndexbean);
                        intent.putExtras(bundle);
                        startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onRefresh() {
        if (!isRefreshing){
            isRefreshing = true;
            swipeIndexmore.post(new Runnable() {
                @Override
                public void run() {
                    swipeIndexmore.setRefreshing(true);
                    getPresenter().getIndexMoreData(1,10,liveIndexbeandata.getTitleId(),isRefreshing);
                }
            });

        }
    }

    @Override
    public void getIndexMoreList(List<LiveIndexbean> movieData) {
        if (movieData.size() > 0){
            livemoveadapter.setNewData(movieData);
        }
    }

    @Override
    public void setRefreshError() {
    }

    @Override
    public void setdisSwiperefresh() {
        if (swipeIndexmore.isRefreshing()){
            swipeIndexmore.setRefreshing(false);
            isRefreshing = false;
        }
    }

    @Override
    public void showFailed() {
        Toast.makeText(this, "获取失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess() {
        Toast.makeText(this, "获取成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMoreRequested() {
        Log.e("onLoadMoreRequested=======","上拉加载");
    }
}
