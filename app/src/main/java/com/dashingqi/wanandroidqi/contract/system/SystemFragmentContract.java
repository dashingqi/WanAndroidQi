package com.dashingqi.wanandroidqi.contract.system;

import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.base.view.BaseView;
import com.dashingqi.wanandroidqi.network.entity.system.SystemDataBean;

import java.util.List;

public interface SystemFragmentContract {

    interface View extends BaseView {
        void showSystemData(List<SystemDataBean> data);
    }

    interface Presenter extends IPresenter<View> {
        void getSystemData();
    }
}
