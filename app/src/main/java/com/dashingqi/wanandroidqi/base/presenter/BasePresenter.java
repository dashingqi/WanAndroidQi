package com.dashingqi.wanandroidqi.base.presenter;

import com.dashingqi.wanandroidqi.base.view.BaseView;
import com.dashingqi.wanandroidqi.model.DataModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

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

    protected V mView;
    protected DataModel mModel;
    private CompositeDisposable mCompositeDisposable;


    @Inject
    public BasePresenter(DataModel dataModel) {
        mModel = dataModel;
    }

    @Override
    public void attachView(V mView) {
        this.mView = mView;

    }

    @Override
    public void detachView() {
        this.mView = null;
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }

    }

    @Override
    public boolean isAttachView() {
        return this.mView != null;
    }

    @Override
    public void addRxSubScribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }

        mCompositeDisposable.add(disposable);

    }

    @Override
    public void subScribeEvent() {

    }
}
