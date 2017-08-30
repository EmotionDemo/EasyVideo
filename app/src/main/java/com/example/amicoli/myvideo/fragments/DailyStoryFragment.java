package com.example.amicoli.myvideo.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.activies.StoryDetialActivity;
import com.example.amicoli.myvideo.adapters.MainPageStoryAdapter;
import com.example.amicoli.myvideo.adapters.SectionItem;
import com.example.amicoli.myvideo.beans.daily.DailyBean;
import com.example.amicoli.myvideo.beans.daily.StoriesBean;
import com.example.amicoli.myvideo.beans.daily.StoryDetailBean;
import com.example.amicoli.myvideo.beans.daily.TopBanners;
import com.example.amicoli.myvideo.beans.daily.TopStoriesBean;
import com.example.amicoli.myvideo.iview.IDailyView_1;
import com.example.amicoli.myvideo.presenter.DailyPresenter_1;
import com.example.amicoli.myvideo.utils.GlideImageLoader;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.wang.avi.AVLoadingIndicatorView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;
import static android.support.v7.widget.StaggeredGridLayoutManager.VERTICAL;

public class DailyStoryFragment extends MvpFragment<IDailyView_1,DailyPresenter_1> implements IDailyView_1,SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.loading_view)
    AVLoadingIndicatorView loadingView;
    @BindView(R.id.view_banner)
    Banner viewBanner;
    @BindView(R.id.rv_story_list)
    RecyclerView rvStoryList;
    @BindView(R.id.nsv_main_scrollview)
    NestedScrollView nsvMainScrollview;
    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout swiperefresh;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private List<SectionItem> tempMainStoryItemWithHeader = null;
    private String tempDate;
    private TextView tvFooter;
    private boolean isRefreshing = false;
    private MainPageStoryAdapter madapter;
    private List<DailyBean>dailyBeen = new ArrayList<>();
    private DailyBean dailyBean ;
    //private StoryDetailBean storyDetailBean = new StoryDetailBean();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_partition, container, false);

        return view;
    }

    public DailyStoryFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public DailyPresenter_1 createPresenter() {
        return new DailyPresenter_1();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        ButterKnife.bind(this, view);
        initSwiperefresh();
        //List<StoriesBean> storiesBeen = dailyBean.getStories();
        initRVStoryList(new DailyBean().getStories());
        getPresenter().fetData(isRefreshing);
        showLoadingView();
    }

    private void initRVStoryList(final List<StoriesBean> storieslist) {
        //重写canScrollVertically 解决滑动卡顿问题
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,VERTICAL){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        staggeredGridLayoutManager.setAutoMeasureEnabled(true);//设置recyclerview自适应高度
        madapter = new MainPageStoryAdapter(R.layout.layout_story_rv_item,R.layout.layout_date_header,null);
        rvStoryList.setNestedScrollingEnabled(true);
        rvStoryList.setAdapter(madapter);
        rvStoryList.setLayoutManager(staggeredGridLayoutManager);
        rvStoryList.setHasFixedSize(true);
        rvStoryList.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                String id = madapter.getItem(position).getStoryId();
                if (id != null)
                startActionForDetial(id);
            }});
    }

    private void startActionForDetial(String id) {
            Intent intent = new Intent(getActivity(),StoryDetialActivity.class);
            intent.putExtra("story_id",id);
            startActivity(intent);
    }

    //初始化主页日报
    public void initMainStoryView(final String date ,List<SectionItem> mainStoryListWitbHeader){
        tempDate = date;
        tempMainStoryItemWithHeader = mainStoryListWitbHeader;
        madapter.setNewData(mainStoryListWitbHeader);
        madapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        madapter.addFooterView(getFooterView());
        madapter.getFooterLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvFooter = (TextView)madapter.getFooterLayout().findViewById(R.id.tv_footer);
                tvFooter.setText(getResources().getString(R.string.text_footer_loading));
                getPresenter().getBeforeData(tempDate);
            }
        });
    }

    private void initSwiperefresh() {
        swiperefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swiperefresh.setSize(swiperefresh.DEFAULT);
        swiperefresh.setOnRefreshListener(this);
        swiperefresh.setDistanceToTriggerSync(300);  //下拉多少会出发刷新效果
        swiperefresh.setProgressViewEndTarget(true,300);// 下拉距离第一个参数是否有动画
    }

    @Override
    public void onRefresh() {
        if (!isRefreshing) {
            isRefreshing = true;
            swiperefresh.post(new Runnable() {
                @Override
                public void run() {
                    swiperefresh.setRefreshing(true);
                    getPresenter().fetData(isRefreshing);
                }
            });
        }
    }

    @Override
    public void setDailyData_1(String date, TopBanners topBanners, List<SectionItem> mainStoryItemListWithHeader) {
        tempDate = date;
        updataBanner(topBanners);
        if (tempMainStoryItemWithHeader != null){
            tempMainStoryItemWithHeader.clear();
            tempMainStoryItemWithHeader.addAll(mainStoryItemListWithHeader);
            madapter.notifyDataSetChanged();
        }else {
            initMainStoryView(date,mainStoryItemListWithHeader);
        }

    }

    private void updataBanner(final TopBanners topBanners) {

        viewBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                startActionForDetial(topBanners.getIdList().get(position));
            }
        });

        viewBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
                .setImageLoader(new GlideImageLoader())
                .setImages(topBanners.getImages())
                .setBannerTitles(topBanners.getTitles())
                .setBannerAnimation(Transformer.Default)
                .start();
    }

    @Override
    public void setRefreshFailed() {
        showFailed();
    }

    @Override
    public void setStopRefresh() {
        if (swiperefresh.isRefreshing()){
            swiperefresh.setRefreshing(false);
            isRefreshing = false;
        }
    }

    @Override
    public void showFailed() {
        hideLoadingView();
        madapter.setEmptyView(getFailedView());
        showFailedToast();
    }


    @Override
    public void refreshSuccess() {
        showScuessToast();
    }

    @Override
    public void showMainPageStoryContent(String date, TopBanners banners, List<SectionItem> mainStroyIremListHeaderView) {
        updataBanner(banners);
        hideLoadingView();
        initMainStoryView(date,mainStroyIremListHeaderView);
    }

    @Override
    public void showLoadMoreFailed() {
        tvFooter.setText(getResources().getString(R.string.text_getstory_list_failed));
        madapter.setEmptyView(getFailedView());
        showFailedToast();
    }

    @Override
    public void loadMore(String date, List<SectionItem> moreStoryItemListWithHeader) {
        madapter.removeAllFooterView();
        tempDate = date;
        tempMainStoryItemWithHeader.addAll(moreStoryItemListWithHeader);
        madapter.notifyDataSetChanged();
        madapter.loadMoreComplete();
        madapter.addFooterView(getFooterView());
        tvFooter.setText(getResources().getString(R.string.text_footer_loadmore));
    }

    @Override
    public void setDaily(final DailyBean dailyBean) {
        //initRVStoryList(dailyBean.getStories());
        this.dailyBean = new DailyBean();
        this.dailyBean = dailyBean;
    }

    public View getFooterView() {
        return getActivity().getLayoutInflater().inflate(R.layout.layout_footer_load_old_content, (ViewGroup) rvStoryList.getParent(), false);
    }
    public View getFailedView() {
        return getActivity().getLayoutInflater().inflate(R.layout.layout_empty_view, (ViewGroup) rvStoryList.getParent(), false);
    }
    private void showScuessToast() {
        Toast.makeText(getContext(), "日报刷新成功", Toast.LENGTH_SHORT).show();
    }
    private void showFailedToast() {
        Toast.makeText(getContext(), "日报刷新失败", Toast.LENGTH_SHORT).show();
    }
    private void showLoadingView() {
        loadingView.show();
    }
    private void hideLoadingView() {
        loadingView.hide();
    }

}
