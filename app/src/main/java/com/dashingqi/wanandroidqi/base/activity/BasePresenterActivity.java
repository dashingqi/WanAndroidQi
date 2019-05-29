package com.dashingqi.wanandroidqi.base.activity;

import com.dashingqi.wanandroidqi.base.presenter.IPresenter;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.base.activity
 * @ClassName: BasePresenterActivity
 * @Author: DashingQI
 * @CreateDate: 2019-05-29 14:40
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-29 14:40
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BasePresenterActivity<P extends IPresenter> extends BaseActivity {

    public P mPresenter;

    public abstract P getPresenter();

    @Override
    protected void initView() {
        mPresenter = getPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView(this);
            mPresenter = null;
        }
    }
}
