package com.dashingqi.wanandroidqi.base.view;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.base.view
 * @ClassName: BaseView
 * @Author: DashingQI
 * @CreateDate: 2019-05-29 14:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-29 14:42
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface BaseView {
    //展示加载中
    void showLoading();

    //隐藏加载中
    void hideLoading();

    //显示错误的布局
    void showErrorView();

    //显示正确的布局
    void showNormalView();

    //显示吐司
    void showToast(String msg);
}
