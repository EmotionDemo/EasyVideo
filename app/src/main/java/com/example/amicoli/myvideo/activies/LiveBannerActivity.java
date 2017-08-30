package com.example.amicoli.myvideo.activies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.example.amicoli.myvideo.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LiveBannerActivity extends BaseActivity {

    @BindView(R.id.myWebView)
    WebView myWebView;
    @BindView(R.id.activity_web_view)
    LinearLayout activityWebView;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_banner);
        ButterKnife.bind(this);

        Intent intent = getIntent();
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle(intent.getStringExtra("title"));
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl(intent.getStringExtra("url"));

    }
}
