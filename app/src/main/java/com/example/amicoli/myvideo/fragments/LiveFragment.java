package com.example.amicoli.myvideo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.activies.LiveBannerActivity;
import com.example.amicoli.myvideo.activies.LivePlayInfoActivity;
import com.example.amicoli.myvideo.adapters.MyLiveMultipleQuickAdapter;
import com.example.amicoli.myvideo.beans.BannerBean;
import com.example.amicoli.myvideo.beans.BiliBiliBean;
import com.example.amicoli.myvideo.beans.CoverBean;
import com.example.amicoli.myvideo.beans.LiveBannerBean;
import com.example.amicoli.myvideo.beans.LiveContnetBean;
import com.example.amicoli.myvideo.beans.LivesBean;
import com.example.amicoli.myvideo.beans.OwnerBean;
import com.example.amicoli.myvideo.beans.PartitionBean;
import com.example.amicoli.myvideo.beans.PartitionsBean;
import com.example.amicoli.myvideo.beans.SubIconBean;
import com.example.amicoli.myvideo.iview.MainInfoView;
import com.example.amicoli.myvideo.presenter.MainPresenter;
import com.example.amicoli.myvideo.utils.GlideImageLoader;
import com.example.amicoli.myvideo.utils.LiveBannerImageLoader;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveFragment extends MvpFragment<MainInfoView, MainPresenter> implements OnBannerClickListener, MainInfoView,SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout swiperefreshlayout;
    private Banner banner;
    private MyLiveMultipleQuickAdapter adapter;
    private PartitionBean partitionsBean;
    private View header;
    private SubIconBean entranceIconBean;
    private OwnerBean ownerBean;
    private CoverBean coverBean;
    private List<LiveContnetBean> liveContnetBean;
    private List<PartitionsBean> partitionBeens = new ArrayList<>();
    private List<LivesBean> livesBeen = new ArrayList<>();
    private LivesBean livesBeen2;
    private int mysize;
    private BannerBean bannerBean;
    private List<BannerBean> bannerBeen = new ArrayList<>();
    private Boolean isRefresh = false;
    private List<LiveBannerBean> beannerList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_live, container, false);
        return view;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        getPresenter().setLiveInfo();
        initSwiperefreshlayout();
        addOprate();
    }

    public LiveFragment() {
    }

    /**
     * @author 李丰华
     * @effect 初始化下拉刷新
     * @date 2017/4/18
     */
    private void initSwiperefreshlayout() {
        swiperefreshlayout.setOnRefreshListener(this);
        swiperefreshlayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swiperefreshlayout.post(new Runnable() {
            @Override
            public void run() {
                swiperefreshlayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void setBiliBiliBean(BiliBiliBean biliBiliBean) {
        liveContnetBean = null;
        liveContnetBean = initData(biliBiliBean);
        adapter = new MyLiveMultipleQuickAdapter(liveContnetBean);
        adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                if (liveContnetBean.get(position).getItemType() == 2) {
                    //是网格
                    return 1;
                }
                return 2;
            }
        });
        bannerBeen.clear();
        bannerBeen = biliBiliBean.getData().getBanner();
        addBanner(bannerBeen);
        //动画
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        adapter.isFirstOnly(false);
        recyclerview.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerview.setAdapter(adapter);
    }

    private List<LiveContnetBean> initData(BiliBiliBean biliBiliBean) {
        List<LiveContnetBean> title_content = new ArrayList<>();
        partitionBeens = biliBiliBean.getData().getPartitions();//title content
        mysize = biliBiliBean.getData().getPartitions().size();
        for (int i = 0; i < mysize; i++) {
            LiveContnetBean liveContnetBean = new LiveContnetBean();
            partitionsBean = partitionBeens.get(i).getPartition();
            entranceIconBean = partitionsBean.getSub_icon();
            liveContnetBean.setId(partitionsBean.getId());
            liveContnetBean.setTitleName(partitionsBean.getName());
            liveContnetBean.setCount(partitionsBean.getCount());
            liveContnetBean.setTitleSrc(entranceIconBean.getSrc());
            liveContnetBean.setItemType(1);
            title_content.add(liveContnetBean);
            // partitionsBean.setItemType(1);
            livesBeen = biliBiliBean.getData().getPartitions().get(i).getLives();
            for (int j = 0; j < 4; j++) {
                liveContnetBean = new LiveContnetBean();
                livesBeen2 = livesBeen.get(j);
                ownerBean = livesBeen2.getOwner();
                coverBean = livesBeen2.getCover();
                liveContnetBean.setTitle(livesBeen2.getTitle());
                liveContnetBean.setRoom_id(livesBeen2.getRoom_id());
                liveContnetBean.setOnline(livesBeen2.getOnline());
                liveContnetBean.setPlayurl(livesBeen2.getPlayurl());

                liveContnetBean.setFace(ownerBean.getFace());
                liveContnetBean.setContentName(ownerBean.getName());
                liveContnetBean.setContentSrc(coverBean.getSrc());
                liveContnetBean.setItemType(2);
                title_content.add(liveContnetBean);
            }
            liveContnetBean = new LiveContnetBean();
            liveContnetBean.setItemType(3);
            title_content.add(liveContnetBean);
        }
        return title_content;
    }


    /**
     * @author 李丰华
     * @effect 添加图片轮播
     * @date 2017/4/19
     */

    private void addBanner(final List<BannerBean> liveBannerBeen) {
        //liveBannerBeen.clear();
        header = LayoutInflater.from(getContext()).inflate(R.layout.banner_recyclerview, null);
        banner = (Banner) header.findViewById(R.id.banner);
        banner.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 320));
        banner.setImages(liveBannerBeen)
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .setImageLoader(new LiveBannerImageLoader())
                .setIndicatorGravity(BannerConfig.RIGHT)
                .setBannerAnimation(Transformer.DepthPage)
                .start();
        adapter.addHeaderView(header);
        View LiveHeader = LayoutInflater.from(getContext()).inflate(R.layout.fragment_live_head_list, null);
        LiveHeader.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        adapter.addHeaderView(LiveHeader);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(getContext(), LiveBannerActivity.class);
                bannerBean = liveBannerBeen.get(position);
                intent.putExtra("title", bannerBean.getRemark());
                intent.putExtra("url", bannerBean.getLink());
                startActivity(intent);
            }
        });
    }


    private void addOprate() {
        recyclerview.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.contnet_item_main:
                        LiveContnetBean item = (LiveContnetBean) adapter.getItem(position);
                        Intent intent = new Intent(getContext(), LivePlayInfoActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("content", item);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                }
            }
        });

    }

    @Override
    public void setdisSwiperefresh() {
        swiperefreshlayout.setRefreshing(false);
    }

    @Override
    public void setRefreshSuccess() {
        Toast.makeText(this.getContext(), "bili获取成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setRefreshError() {
        Toast.makeText(getContext(), "bili获取失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        if (banner != null) {
            banner.stopAutoPlay();
        }
    }

    @Override
    public void OnBannerClick(int position) {

    }
    @Override
    public void onRefresh() {
        getPresenter().setLiveInfo();
        swiperefreshlayout.setRefreshing(false);
    }
}
