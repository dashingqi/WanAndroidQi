package com.dashingqi.wanandroidqi.base.presenter;

import com.dashingqi.wanandroidqi.base.view.BaseView;

import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.base.presenter
 * @ClassName: IPresenter
 * @Author: DashingQI
 * @CreateDate: 2019-05-29 14:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-29 14:42
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IPresenter<V extends BaseView> {


    /**
     * 绑定View
     *
     * @param mView
     */
    void attachView(V mView);

    /**
     * 解绑View
     */
    void detachView();

    /**
     * 当前View是否处于绑定的状态
     *
     * @return
     */
    boolean isAttachView();

    /**
     * 管理Rx的订阅事件
     *
     * @param disposable
     */
    void addRxSubScribe(Disposable disposable);

    /**
     * 订阅事件
     */
    void subScribeEvent();

}
