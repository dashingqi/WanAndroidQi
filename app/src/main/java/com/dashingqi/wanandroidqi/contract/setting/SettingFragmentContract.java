package com.dashingqi.wanandroidqi.contract.setting;

import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.base.view.BaseView;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.contract.setting
 * @ClassName: SettingFragmentContract
 * @Author: DashingQI
 * @CreateDate: 2019-05-31 08:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-31 08:44
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface SettingFragmentContract {

    interface View extends BaseView {
        void showSettingData(String data);
    }

    interface Presenter extends IPresenter<View> {
        void loadSettingData();
    }
}
