package com.dashingqi.wanandroidqi.view.home;


import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.adapter.ArticlesAdapter;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.contract.home.HomeFragmentContract;
import com.dashingqi.wanandroidqi.di.module.home.HomeFragmentModule;
import com.dashingqi.wanandroidqi.network.entity.home.ArticleBean;
import com.dashingqi.wanandroidqi.network.entity.home.BannerDataBean;
import com.dashingqi.wanandroidqi.presenter.home.HomeFragmentPresenter;
import com.dashingqi.wanandroidqi.utils.image.BannerImageLoader;
import com.dashingqi.wanandroidqi.view.MainActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.view.home
 * @ClassName: HomeFragment
 * @Author: DashingQI
 * @CreateDate: 2019/5/11 7:44 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/11 7:44 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
public class HomeFragment extends BaseLoadingFragment<HomeFragmentPresenter> implements HomeFragmentContract.View {
    private static final String TAG = "HomeFragment";

    @BindView(R.id.mSmartRefreshLayout)
    protected SmartRefreshLayout mSmartRefreshLayout;

    @BindView(R.id.mRecyclerView)
    protected RecyclerView mRecyclerView;

    @Inject
    HomeFragmentPresenter mPresenter;

    @Inject
    @Named("bannerTitles")
    List<String> bannerTitles;

    @Inject
    @Named("bannerImages")
    List<String> bannerImages;

    @Inject
    @Named("bannerUrls")
    List<String> bannerUrls;

    @Inject
    List<ArticleBean> articleList;

    @Inject
    ArticlesAdapter mArticleAdapter;
    @Inject
    LinearLayoutManager mLinearLayoutManager;
    private Banner mBanner;

    private int pageNum = 0;
    private boolean isRefresh = false;

    @Override
    protected void initData() {

    }

    @Override
    public HomeFragmentPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void initView() {
        super.initView();
        initRecyclerView();
        initPullToRefresh();
    }

    private void initPullToRefresh() {
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                Log.d(TAG, "onRefresh: ");
                pageNum = 0;
                isRefresh = true;
                mPresenter.loadMoreData(pageNum);

            }
        });

        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                Log.d(TAG, "onLoadMore: ");
                pageNum++;
                isRefresh = false;
                mPresenter.loadMoreData(pageNum);
            }
        });
    }

    @Override
    protected void loadData() {
        mPresenter.loadBannerData();
        mPresenter.loadData(0);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    public void showBannerData(List<BannerDataBean> bannerDataBeanList) {
        for (BannerDataBean bannerDataBean : bannerDataBeanList) {
            bannerTitles.add(bannerDataBean.getTitle());
            bannerImages.add(bannerDataBean.getImagePath());
            bannerUrls.add(bannerDataBean.getUrl());
        }

        mBanner.setImageLoader(new BannerImageLoader())
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImages(bannerImages)
                .setBannerAnimation(Transformer.Default)
                .setBannerTitles(bannerTitles)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .setDelayTime(3000)
                .start();
    }

    @Override
    public void showData(List<ArticleBean> data) {
        Log.d(TAG, "size = " + data.size());
        articleList.addAll(data);
        mArticleAdapter.notifyDataSetChanged();

    }

    @Override
    public void showMoreData(List<ArticleBean> data) {
        if (isRefresh) {
            if (articleList != null && articleList.size() > 0) {
                articleList.clear();
            }
            //结束下拉加载
            mSmartRefreshLayout.finishRefresh();
        } else {
            if (articleList.size() == 0)
                mSmartRefreshLayout.finishLoadMoreWithNoMoreData();
            else
                mSmartRefreshLayout.finishLoadMore(4000);
        }

        articleList.addAll(data);
        mArticleAdapter.notifyDataSetChanged();


    }

    @Override
    public void autoRefresh() {

    }

    @Override
    protected void inject() {
        ((MainActivity) mActivity).
                getComponent().
                getHomeFragmentComponent(new HomeFragmentModule()).
                inject(HomeFragment.this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBanner.stopAutoPlay();
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        View mBannerLayout = LayoutInflater.from(mActivity).inflate(R.layout.home_banner_layout, null);
        mBanner = mBannerLayout.findViewById(R.id.banner);
        mArticleAdapter.addHeaderView(mBannerLayout);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mArticleAdapter);
    }
}
