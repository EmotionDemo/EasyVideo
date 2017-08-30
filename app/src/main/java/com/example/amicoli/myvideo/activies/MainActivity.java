package com.example.amicoli.myvideo.activies;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.amicoli.myvideo.R;
import com.example.amicoli.myvideo.fragments.DownLoadFragment;
import com.example.amicoli.myvideo.fragments.TopFragment;
import com.example.amicoli.myvideo.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.ll_drawer)
    LinearLayout llDrawer;
    @BindView(R.id.content_main)
    LinearLayout contentMain;
    @BindView(R.id.coorLayout)
    CoordinatorLayout coorLayout;
    @BindView(R.id.navigation)
    NavigationView navigation;
    @BindView(R.id.drawer)
    DrawerLayout drawer;
    @BindView(R.id.toolbar_for_mainpage)
    Toolbar toolbarForMainpage;

    private NavigationView navigationView;
    private TopFragment topFragment = new TopFragment();
    private DownLoadFragment downLoadFragment = new DownLoadFragment();
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbarForMainpage.setTitle(" ");
        setSupportActionBar(toolbarForMainpage);
        initNavigation();
        initTopFragment();
    }

    /**
     * @author 李丰华
     * @effect 初始化导航栏
     * @date 2017/4/16
     */
    private void initNavigation() {
        navigationView = (NavigationView) findViewById(R.id.navigation);
        disableNavigationViewScrollbars(navigationView);
        llDrawer.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        //如果打开侧滑，按返回键先退出侧滑再退出项目
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 主界面不需要支持滑动返回，重写该方法永久禁用当前界面的滑动返回功能
     *
     * @return
     */
    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //绑定Toolbar菜单
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    /**
     * 隐藏navigation滚动条
     *
     * @param
     */
    private void disableNavigationViewScrollbars(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    /**
     * @author 李丰华
     * @effect 初始化默认fragment
     * @date 2017/4/16
     */
    public void initTopFragment() {
        topFragment = new TopFragment();
        FragmentManager manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.content_main, topFragment);
        transaction.commit();
        navigationView.setCheckedItem(R.id.item_home);
    }

    /**
     * @author 李丰华
     * @effect 替换fragment
     * @date 2017/4/16
     */

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.commit();
        navigationView.setCheckedItem(R.id.item_home);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //ToolBar的点击事件
        int id = item.getItemId();
        if (id == R.id.action_game) {
            //游戏
            return true;
        } else if (id == R.id.action_download) {
            //下载
            return true;
        } else if (id == R.id.action_search) {
            //搜索
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSaveInstanceState(Bundle outState) {
        //注释掉以防view重叠
        //super.onSaveInstanceState(outState, outPersistentState);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_home) {
            replaceFragment(topFragment);
        } else if (id == R.id.item_app) {

        } else if (id == R.id.action_search) {

        } else if (id == R.id.item_down) {
            replaceFragment(downLoadFragment);
        } else if (id == R.id.item_favourite) {

        } else if (id == R.id.item_group) {
            // replaceFragment();

        } else if (id == R.id.item_history) {
            // replaceFragment();

        } else if (id == R.id.item_settings) {
            // replaceFragment();

        } else if (id == R.id.item_theme) {
            // replaceFragment();

        } else if (id == R.id.item_tracker) {
            // replaceFragment();
        } else if (id == R.id.item_vip) {
            // replaceFragment();
        }
//        switch (id){
//            case R.id.item_home:
//                replaceFragment(topFragment);
//                break;
//            case R.id.action_download:
//                replaceFragment(downLoadFragment);
//                break;
//        }
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_drawer:
                drawer.openDrawer(GravityCompat.START);
                break;
        }
    }


}
