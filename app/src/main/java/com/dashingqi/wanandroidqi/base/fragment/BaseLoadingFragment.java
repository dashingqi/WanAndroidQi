package com.dashingqi.wanandroidqi.base.fragment;

import com.dashingqi.wanandroidqi.base.presenter.IPresenter;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.base.fragment
 * @ClassName: BaseLoadingFragment
 * @Author: DashingQI
 * @CreateDate: 2019-05-30 21:48
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-30 21:48
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseLoadingFragment<P extends IPresenter> extends BasePresenterFragment<P> {

    @Override
    public void showLoading() {

        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }

    }

    @Override
    public void hideLoading() {

        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }

    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void showNormalView() {

    }
}
