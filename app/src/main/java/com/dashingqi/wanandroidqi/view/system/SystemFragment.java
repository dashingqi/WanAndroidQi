package com.dashingqi.wanandroidqi.view.system;


import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.contract.system.SystemContract;
import com.dashingqi.wanandroidqi.di.module.system.SystemFragmentModule;
import com.dashingqi.wanandroidqi.presenter.system.SystemFragmentPresenter;
import com.dashingqi.wanandroidqi.view.MainActivity;

import javax.inject.Inject;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.view.system
 * @ClassName: SystemFragment
 * @Author: DashingQI
 * @CreateDate: 2019/5/11 7:45 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/11 7:45 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
public class SystemFragment extends BaseLoadingFragment<SystemFragmentPresenter> implements SystemContract.View {

    @Inject
    protected SystemFragmentPresenter mSystemFragmentPresenter;

    @Override
    protected void initData() {

    }

    @Override
    public SystemFragmentPresenter getPresenter() {
        return mSystemFragmentPresenter;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {
        mSystemFragmentPresenter.getSystemData();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_system;
    }

    @Override
    protected void inject() {
        ((MainActivity) mActivity)
                .getComponent()
                .getSystemFragmentComponent(new SystemFragmentModule())
                .inject(this);

    }

    @Override
    public void showSystemData() {
        //获取到知识体系的数据
    }
}
