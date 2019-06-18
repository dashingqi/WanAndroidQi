package com.dashingqi.wanandroidqi.view.wechat;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.adapter.TabAdapter;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.contract.wx.WxFragmentContact;
import com.dashingqi.wanandroidqi.di.module.wx.WxFragmentModule;
import com.dashingqi.wanandroidqi.network.entity.wx.WxTabData;
import com.dashingqi.wanandroidqi.presenter.wx.WxFragmentPresenter;
import com.dashingqi.wanandroidqi.view.MainActivity;
import com.dashingqi.wanandroidqi.view.project.ProjectFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.view.wechat
 * @ClassName: WeChatFragment
 * @Author: DashingQI
 * @CreateDate: 2019/5/11 7:45 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/11 7:45 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
public class WeChatFragment extends BaseLoadingFragment<WxFragmentPresenter> implements WxFragmentContact.View {
    private static final String TAG = "WeChatFragment";

    @Inject
    WxFragmentPresenter mWxFragmentPresenter;

    @Inject
    @Named("WxTabNameList")
    List<String> wxTabNames;

    @Inject
    @Named("WxTabFragmentList")
    List<Fragment> wxTabFragments;

    @BindView(R.id.mSlidingTabLayout)
    protected SlidingTabLayout mSlidingTabLayout;

    @BindView(R.id.mWxViewPager)
    protected ViewPager mViewPager;

    @Override
    protected void initData() {

    }

    @Override
    public WxFragmentPresenter getPresenter() {
        return mWxFragmentPresenter;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {
        //获取到微信公众号tab数据
        mWxFragmentPresenter.getWxTabData();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_we_chat;
    }

    @Override
    protected void inject() {
        ((MainActivity) mActivity)
                .getComponent()
                .getWxFragmentComponent(new WxFragmentModule())
                .inject(this);
    }

    @Override
    public void showWxTab(List<WxTabData> dataList) {
        for (WxTabData wxTabData : dataList) {
            wxTabNames.add(wxTabData.getName());
        }
        Log.d(TAG, "showWxTab:names size " + wxTabNames.size());

        for (int i = 0; i < wxTabNames.size(); i++) {
            wxTabFragments.add(new ProjectFragment());
        }

        Log.d(TAG, "showWxTab: fragments size" + wxTabFragments.size());

        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager(), wxTabNames, wxTabFragments);
        mViewPager.setAdapter(tabAdapter);
        mSlidingTabLayout.setViewPager(mViewPager);
    }
}
