package com.dashingqi.wanandroidqi.contract.project;

import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.base.view.BaseView;

public interface ProjectListContract {

    interface View extends BaseView {
        void showListData();

        void showMoreListData();
    }

    interface Presenter extends IPresenter<View> {
        void getListData(int pageNum,int cid);

        void getListMoreData(int pageNum,int cid);
    }
}
