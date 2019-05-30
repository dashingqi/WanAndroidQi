package com.dashingqi.wanandroidqi.base.fragment;

import com.dashingqi.wanandroidqi.base.presenter.IPresenter;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.base.fragment
 * @ClassName: BasePresenterFragment
 * @Author: DashingQI
 * @CreateDate: 2019-05-30 20:09
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-30 20:09
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BasePresenterFragment<P extends IPresenter> extends BaseFragment {

    public P mPresenter;

    public abstract P getPresenter();

    @Override
    protected void initView() {
        mPresenter = getPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
