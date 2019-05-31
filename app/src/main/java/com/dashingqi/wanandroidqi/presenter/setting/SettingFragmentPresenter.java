package com.dashingqi.wanandroidqi.presenter.setting;

import com.dashingqi.wanandroidqi.base.model.CallBack;
import com.dashingqi.wanandroidqi.base.model.DataModel;
import com.dashingqi.wanandroidqi.base.presenter.BasePresenter;
import com.dashingqi.wanandroidqi.contract.setting.SettingFragmentContract;
import com.dashingqi.wanandroidqi.model.setting.SettingModel;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.presenter.setting
 * @ClassName: SettingFragmentPresenter
 * @Author: DashingQI
 * @CreateDate: 2019-05-31 08:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-31 08:51
 * @UpdateRemark:
 * @Version: 1.0
 */
public class SettingFragmentPresenter extends BasePresenter<SettingFragmentContract.View> implements SettingFragmentContract.Presenter {
    @Override
    public void loadSettingData() {
        if (isAttachView()) {
            mView.showLoading();
            DataModel
                    .getInstance(SettingModel.class)
                    .params("1")
                    .execute(new CallBack<String>() {

                        @Override
                        public void onSuccess(String data) {
                            mView.showSettingData(data);
                        }

                        @Override
                        public void onFailed(String data) {

                        }

                        @Override
                        public void onError() {

                        }

                        @Override
                        public void onComplete() {
                            mView.hideLoading();
                        }
                    });
        }
    }

}
