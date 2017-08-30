package com.example.amicoli.myvideo.fragments;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.activies.LiveIndexMoreActivity;
import com.example.amicoli.myvideo.activies.LiveMovieActivity;
import com.example.amicoli.myvideo.activies.LivePlayInfoActivity;
import com.example.amicoli.myvideo.activies.LivePlayerActivity;
import com.example.amicoli.myvideo.adapters.LiveMovieAdapter;
import com.example.amicoli.myvideo.beans.movie.LiveIndexbean;
import com.example.amicoli.myvideo.beans.movie.MovieData;
import com.example.amicoli.myvideo.iview.IMovieLiveView;
import com.example.amicoli.myvideo.presenter.MoiveLivePresenter;
import com.hannesdorfmann.mosby.mvp.MvpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieFragment extends MvpFragment<IMovieLiveView, MoiveLivePresenter> implements IMovieLiveView,SwipeRefreshLayout.OnRefreshListener,BaseMultiItemQuickAdapter.RequestLoadMoreListener{

    @BindView(R.id.rv_story_list)
    RecyclerView rvStoryList;
    @BindView(R.id.nsv_main_scrollview)
    NestedScrollView nsvMainScrollview;
    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout swiperefresh;
    private boolean isRefreshing = false;
    private List<LiveIndexbean> liveindexbeen = new ArrayList<>();
    private int page = 1;
    private boolean isLoadMore = false;
    private ProgressBar progressbar;
    private LiveMovieAdapter livemovieadapter;
    private MovieData movieData;
    private GridLayoutManager gridLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        return view;
    }

    public MovieFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public MoiveLivePresenter createPresenter() {
        return new MoiveLivePresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        ButterKnife.bind(this, view);
        initSwiperefresh();
        initAdapter();
        getPresenter().getLiveMovieList(1,10,true);
        addStart();
    }

    private void initSwiperefresh() {
        swiperefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swiperefresh.setSize(swiperefresh.DEFAULT);
        swiperefresh.setOnRefreshListener(this);
        swiperefresh.setDistanceToTriggerSync(300);  //根据下拉距离触发刷新效果
        swiperefresh.setProgressViewEndTarget(true,300);// 下拉距离第一个参数是
        swiperefresh.post(new Runnable() {
            @Override
            public void run() {
                swiperefresh.setRefreshing(true);
            }
        });
    }

    @Override
    public void setMovieData(final MovieData moviedata){
        Log.e("setMovieData:===", moviedata.toString());
       this.movieData = moviedata;
        liveindexbeen.clear();
        if (moviedata.getBody().size()>0){
            livemovieadapter.setNewData(getMovieData(moviedata));
            if (isLoadMore){
                isLoadMore = false;
                livemovieadapter.addData(getMovieData(moviedata));
                livemovieadapter.notifyDataSetChanged();
                livemovieadapter.loadMoreComplete();
            }
           //return;
        }
        isLoadMore = false;
        livemovieadapter.loadMoreEnd();
    }

    private void initAdapter() {
        livemovieadapter = new LiveMovieAdapter(null);
        livemovieadapter.setOnLoadMoreListener(this);
        livemovieadapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                if (liveindexbeen.get(position).getItemType() == 0){
                    return 3;
                }
                return 1;
            }
        });
        livemovieadapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        //重写GridView解决卡顿问题
        gridLayoutManager = new GridLayoutManager(this.getActivity(),3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rvStoryList.setLayoutManager(gridLayoutManager);
        rvStoryList.setAdapter(livemovieadapter);

    }

    private void addStart() {
        rvStoryList.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.live_movie_content:
                        LiveIndexbean liveindexbean = (LiveIndexbean) adapter.getItem(position);
                        // Toast.makeText(getContext(), "你点击了"+position, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getContext(),LivePlayerActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("IndexData",liveindexbean);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    case R.id.rv_live_movie_more:
                        LiveIndexbean liveindexbean1 = (LiveIndexbean) adapter.getItem(position);
                        Intent intent_more = new Intent(getContext(),LiveIndexMoreActivity.class);
                        Bundle bundle_more = new Bundle();
                        bundle_more.putSerializable("IndexData",liveindexbean1);
                        intent_more.putExtras(bundle_more);
                        startActivity(intent_more);
                        break;
                }
            }
        });
    }


    //获取相应数据
    private List<LiveIndexbean> getMovieData(MovieData moviedata) {
        for (int i = 0;i<moviedata.getBody().size();i++){
            LiveIndexbean liveindexbean = new LiveIndexbean();
            liveindexbean.setTitleName(moviedata.getBody().get(i).getName());
            liveindexbean.setTitleId(moviedata.getBody().get(i).getId());
            liveindexbean.setType(0);
            liveindexbeen.add(liveindexbean);
            for (int j = 0;j<moviedata.getBody().get(i).getSubjects().size();j++){
                LiveIndexbean liveindexbean2 = new LiveIndexbean();
                MovieData.BodyBean.SubjectsBean subjectsbean = moviedata.getBody().get(i).getSubjects().get(j);
                liveindexbean2.setType(1);
                liveindexbean2.setScore(moviedata.getBody().get(i).getSubjects().get(j).getScore());
                liveindexbean2.setDoubanId(subjectsbean.getDoubanId());
                liveindexbean2.setTopicId(subjectsbean.getTopicId());
                liveindexbean2.setImg(subjectsbean.getImg());
                liveindexbean2.setName(subjectsbean.getName());
                liveindexbean2.setIndex(subjectsbean.getIndex());
                liveindexbean2.setPid(subjectsbean.getPid());
                liveindexbean2.setMovieId(subjectsbean.getMovieId());
                liveindexbean2.setId(subjectsbean.getId());
                liveindexbean2.setAlbum(subjectsbean.isAlbum());
                liveindexbean2.setShow(subjectsbean.isShow());
                liveindexbean2.setV3Show(subjectsbean.isV3Show());
                liveindexbeen.add(liveindexbean2);
            }
        }

        return liveindexbeen;
    }

    @Override
    public void getSuccess() {
        Toast.makeText(getActivity(), "movie获取成功", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void getError() {
        livemovieadapter.loadMoreFail();
        Toast.makeText(getActivity(), "movie获取失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setdisSwiperefresh() {
        if (swiperefresh.isRefreshing()){
            swiperefresh.setRefreshing(false);
            isRefreshing = false;
        }
    }

    @Override
    public void setRefreshSuccess() {
        Toast.makeText(getActivity(), "movie刷新成功", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public void setRefreshError() {
        Toast.makeText(getActivity(), "movie刷新失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailed() {
        Toast.makeText(getActivity(), "movie获取失败", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onRefresh() {
        if (!isRefreshing){
            isRefreshing = true;
            swiperefresh.post(new Runnable() {
                @Override
                public void run() {
                    swiperefresh.setRefreshing(true);
                    getPresenter().getLiveMovieList(1,10,isRefreshing);
                }
            });
        }
    }

    @Override
    public void onLoadMoreRequested() {
        if (!isLoadMore){
            isLoadMore = true;
            page+=1;
            getPresenter().getLiveMovieList(page,10,true);
        }
    }
}
