package com.dashingqi.wanandroidqi.base.presenter;

import com.dashingqi.wanandroidqi.base.view.BaseView;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.base.presenter
 * @ClassName: BasePresenter
 * @Author: DashingQI
 * @CreateDate: 2019-05-29 15:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-29 15:13
 * @UpdateRemark:
 * @Version: 1.0
 */
public class BasePresenter<V extends BaseView> implements IPresenter<V> {

    public V mView;

    @Override
    public void attachView(V mView) {
        this.mView = mView;

    }

    @Override
    public void detachView(V mView) {
        this.mView = null;

    }

    @Override
    public boolean isAttachView() {
        return this.mView != null;
    }
}
