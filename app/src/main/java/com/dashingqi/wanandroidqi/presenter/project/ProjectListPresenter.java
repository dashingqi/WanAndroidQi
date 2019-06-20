package com.dashingqi.wanandroidqi.presenter.project;

import android.util.Log;

import com.dashingqi.wanandroidqi.base.Observer.BaseObserver;
import com.dashingqi.wanandroidqi.base.presenter.BasePresenter;
import com.dashingqi.wanandroidqi.contract.project.ProjectListContract;
import com.dashingqi.wanandroidqi.model.DataModel;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectListBean;
import com.dashingqi.wanandroidqi.utils.RxUtil;

import javax.inject.Inject;

public class ProjectListPresenter extends BasePresenter<ProjectListContract.View> implements ProjectListContract.Presenter {
    @Inject
    public ProjectListPresenter(DataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void getListData(int pageNum, int cid) {
        addRxSubScribe(
                mModel.getProjectListData(pageNum, cid)
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribeWith(new BaseObserver<ProjectListBean>(mView, false, false) {
                            @Override
                            public void onNext(ProjectListBean projectListBean) {
                                super.onNext(projectListBean);
                                mView.showListData(projectListBean);
                            }
                        })
        );

    }

    @Override
    public void getListMoreData(int pageNum, int cid) {
            addRxSubScribe(
                    mModel.getProjectListData(pageNum,cid)
                    .compose(RxUtil.rxSchedulerHelper())
                    .compose(RxUtil.handleResult())
                    .subscribeWith(new BaseObserver<ProjectListBean>(mView ,false,false){
                        @Override
                        public void onNext(ProjectListBean projectListBean) {
                            super.onNext(projectListBean);
                            mView.showMoreListData(projectListBean);
                        }
                    })
            );
    }
}
