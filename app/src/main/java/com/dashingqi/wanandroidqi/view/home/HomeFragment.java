package com.dashingqi.wanandroidqi.view.home;


import android.widget.TextView;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.contract.home.HomeFragmentContract;
import com.dashingqi.wanandroidqi.dagger2.component.fragment.home.DaggerHomeFragmentComponent;
import com.dashingqi.wanandroidqi.presenter.home.HomeFragmentPresenter;

import javax.inject.Inject;

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

    @Inject
    HomeFragmentPresenter homeFragmentPresenter;

    @Override
    protected void initData() {

    }

    @Override
    public HomeFragmentPresenter getPresenter() {
        return homeFragmentPresenter;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void loadData() {

        mPresenter.loadBannerData("1");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void showBannerData(String data) {
        mTvText.setText(data);
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
        //((MainActivity) mActivity).getComponent().getHomeFragmentComponent().inject(HomeFragment.this);
        DaggerHomeFragmentComponent.create().inject(HomeFragment.this);
    }
}
