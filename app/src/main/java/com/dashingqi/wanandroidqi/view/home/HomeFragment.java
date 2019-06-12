package com.dashingqi.wanandroidqi.view.home;


import android.widget.TextView;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.contract.home.HomeFragmentContract;
import com.dashingqi.wanandroidqi.di.module.home.HomeFragmentModule;
import com.dashingqi.wanandroidqi.network.entity.home.BannerDataBean;
import com.dashingqi.wanandroidqi.presenter.home.HomeFragmentPresenter;
import com.dashingqi.wanandroidqi.utils.image.BannerImageLoader;
import com.dashingqi.wanandroidqi.view.MainActivity;
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

    @BindView(R.id.mTvText)
    protected TextView mTvText;

    @BindView(R.id.banner)
    protected Banner mBanner;

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
    public void showData() {


    }

    @Override
    public void showMoreData() {

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
}
