package com.dashingqi.wanandroidqi.contract.main;

import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.base.view.BaseView;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.contract.main
 * @ClassName: MainContract
 * @Author: DashingQI
 * @CreateDate: 2019-05-29 15:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-29 15:03
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface MainContract {

    interface View extends BaseView {
        //展示更新的对话框
        void showUpdateDialog();
    }

    interface Presenter extends IPresenter<View> {

        //检查apk的版本信息
        void checkApkVersion();


    }
}
