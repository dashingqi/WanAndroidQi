package com.dashingqi.wanandroidqi.view.system;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.adapter.TabAdapter;
import com.dashingqi.wanandroidqi.base.activity.BaseActivity;
import com.dashingqi.wanandroidqi.common.IntentParams;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SystemArticleActivity extends BaseActivity {

    @BindView(R.id.mAppBarLayout)
    protected AppBarLayout mAppBarLayout;

    @BindView(R.id.mViewPager)
    protected ViewPager mViewPager;

    @BindView(R.id.mSlidingTabLayout)
    protected SlidingTabLayout mSlidingTabLayout;

    @BindView(R.id.mToolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.mToolbarTitle)
    protected TextView mToolbarTitle;

    private String mArticleTitle;
    private ArrayList<String> mTabNamesList;
    private ArrayList<Integer> mTabIdsList;
    private List<Fragment> mFragmentsList;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        getData();
        initToolBar();
        initTabLayout();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_system_article;
    }

    @Override
    protected void inject() {

    }


    /**
     * 初始化RecyclerView和 TabLayout
     */
    private void initTabLayout() {
        mFragmentsList = new ArrayList<>();
        for (int i = 0; i < mTabNamesList.size(); i++) {
            mFragmentsList.add(new SystemArticleFragment());
        }
        TabAdapter mTabAdapter = new TabAdapter(getSupportFragmentManager(), mTabNamesList, mFragmentsList);
        mViewPager.setAdapter(mTabAdapter);
        mSlidingTabLayout.setViewPager(mViewPager);
    }


    /**
     * 初始化标题栏
     */
    private void initToolBar() {

        setSupportActionBar(mToolbar);
        mToolbarTitle.setText(mArticleTitle);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //设置返回键
            actionBar.setDisplayHomeAsUpEnabled(true);
            //不显示原有的标题
            actionBar.setDisplayShowTitleEnabled(false);
        }

        //为现有的标题栏设置返回事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    /**
     * 获取数据
     */
    private void getData() {
        Intent intent = getIntent();
        if (intent != null) {
            mArticleTitle = intent.getStringExtra(IntentParams.ARTICLETITLE);
            mTabNamesList = intent.getStringArrayListExtra(IntentParams.ARTICLE_TAB_NAMES_LIST);
            mTabIdsList = intent.getIntegerArrayListExtra(IntentParams.ARTICLE_TAB_IDS_LIST);
        }
    }

    public static void startActivityByFragment(Activity mActivity, String titleText,
                                               List<String> tabsNameList,
                                               List<Integer> tabsIdList) {

        Intent intent = new Intent(mActivity, SystemArticleActivity.class);
        intent.putExtra(IntentParams.ARTICLETITLE, titleText);
        intent.putStringArrayListExtra(IntentParams.ARTICLE_TAB_NAMES_LIST, (ArrayList<String>) tabsNameList);
        intent.putIntegerArrayListExtra(IntentParams.ARTICLE_TAB_IDS_LIST, (ArrayList<Integer>) tabsIdList);
        mActivity.startActivity(intent);

    }
}
