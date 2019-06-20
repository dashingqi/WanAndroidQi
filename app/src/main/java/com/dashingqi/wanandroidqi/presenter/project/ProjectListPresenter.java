package com.dashingqi.wanandroidqi.presenter.project;

import com.dashingqi.wanandroidqi.base.presenter.BasePresenter;
import com.dashingqi.wanandroidqi.contract.project.ProjectListContract;
import com.dashingqi.wanandroidqi.model.DataModel;

import javax.inject.Inject;

public class ProjectListPresenter extends BasePresenter<ProjectListContract.View> implements ProjectListContract.Presenter{
    @Inject
    public ProjectListPresenter(DataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void getListData() {

    }

    @Override
    public void getListMoreData() {

    }
}
