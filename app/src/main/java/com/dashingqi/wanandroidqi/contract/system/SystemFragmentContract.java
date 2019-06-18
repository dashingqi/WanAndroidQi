package com.dashingqi.wanandroidqi.contract.system;

import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.base.view.BaseView;

public interface SystemFragmentContract {

    interface View extends BaseView {
        void showSystemData();
    }

    interface Presenter extends IPresenter<View> {
        void getSystemData();
    }
}
