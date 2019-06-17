package com.dashingqi.wanandroidqi.view.wechat;


import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.base.fragment.BaseFragment;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.contract.wx.WxFragmentContact;
import com.dashingqi.wanandroidqi.di.module.wx.WxFragmentModule;
import com.dashingqi.wanandroidqi.network.entity.wx.WxTabData;
import com.dashingqi.wanandroidqi.presenter.wx.WxFragmentPresenter;
import com.dashingqi.wanandroidqi.view.MainActivity;

import java.util.List;

import javax.inject.Inject;

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
public class WeChatFragment extends BaseLoadingFragment implements WxFragmentContact.View {

    @Inject
    WxFragmentPresenter mWxFragmentPresenter;

    @Override
    protected void initData() {

    }

    @Override
    public IPresenter getPresenter() {
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

    }
}
