package com.dashingqi.wanandroidqi.view;


import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.application.ApplicationQi;
import com.dashingqi.wanandroidqi.base.activity.BasePresenterActivity;
import com.dashingqi.wanandroidqi.common.IntentParams;
import com.dashingqi.wanandroidqi.contract.home.ArticleDetailContract;
import com.dashingqi.wanandroidqi.di.component.fragment.home.DaggerArticleActivityComponent;
import com.dashingqi.wanandroidqi.presenter.home.ArticleDetailActivityPresenter;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;

import javax.inject.Inject;

import butterknife.BindView;

public class ArticleDetailActivity extends BasePresenterActivity<ArticleDetailActivityPresenter> implements ArticleDetailContract.View {

    private static final String TAG = "ArticleDetailActivity";

    @BindView(R.id.mToolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.mContainerFrameLayout)
    protected FrameLayout mContainerFrameLayout;

    @Inject
    protected ArticleDetailActivityPresenter mArticleDetailActivityPresenter;
    private String mArticleUrl;
    private String mArticleTitle;
    private AgentWeb mAgentWeb;

    @Override
    public ArticleDetailActivityPresenter getPresenter() {
        return mArticleDetailActivityPresenter;
    }

    @Override
    protected void initView() {
        super.initView();
        getBundleData();
        initToolbar();
    }

    @Override
    protected void initData() {
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mContainerFrameLayout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator(getResources().getColor(R.color.colorPrimary))
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)
                .createAgentWeb()
                .ready()
                .go(mArticleUrl);
        WebView mWebView = mAgentWeb.getWebCreator().getWebView();
        WebSettings mSettings = mWebView.getSettings();
        mSettings.setAppCacheEnabled(true);
        mSettings.setDomStorageEnabled(true);
        mSettings.setDatabaseEnabled(true);

        mSettings.setJavaScriptEnabled(true);
        mSettings.setSupportZoom(true);
        mSettings.setBuiltInZoomControls(true);

        //不显示缩放按钮
        mSettings.setDisplayZoomControls(false);
        //设置自动适应屏幕
        //将图片调整到适合WebView的大小
        mSettings.setUseWideViewPort(true);
        //缩放到屏幕的大小
        mSettings.setLoadWithOverviewMode(true);
        //自动适应屏幕
        mSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_article_detail;
    }

    @Override
    protected void inject() {
        DaggerArticleActivityComponent.builder()
                .appComponent(ApplicationQi.getAppComponent())
                .build()
                .inject(this);


    }

    @Override
    public void shoeCollectArticleSuccess() {

    }

    @Override
    public void showUnCollectArticleSuccess() {

    }

    /**
     * 获取Fragment传递的数据
     */
    private void getBundleData() {
        Intent intent = getIntent();
        if (intent != null) {
            mArticleUrl = intent.getStringExtra(IntentParams.ARTICLEURL);
            mArticleTitle = intent.getStringExtra(IntentParams.ARTICLETITLE);
        }

        Log.d(TAG, "getBundleData: " + mArticleUrl);
        Log.d(TAG, "getBundleData: " + mArticleTitle);

    }

    /**
     * 初始化Toolbar
     */
    private void initToolbar() {
        // ?? TODO 为什么呢？
        mToolbar.setTitle(Html.fromHtml(mArticleTitle));
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            //设置返回键
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        //为返回键设置点击事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static void startActivityForResultByFragment(Activity activity,
                                                        Fragment mFragment,
                                                        String mArticleTitle,
                                                        String mArticleUrl,
                                                        int request) {
        Intent intent = new Intent(activity, ArticleDetailActivity.class);
        intent.putExtra(IntentParams.ARTICLETITLE, mArticleTitle);
        intent.putExtra(IntentParams.ARTICLEURL, mArticleUrl);
        mFragment.startActivityForResult(intent, request);
    }
}
