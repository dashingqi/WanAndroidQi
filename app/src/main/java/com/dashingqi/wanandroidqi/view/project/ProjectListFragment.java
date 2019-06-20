package com.dashingqi.wanandroidqi.view.project;

import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.contract.project.ProjectContract;
import com.dashingqi.wanandroidqi.di.module.project.ProjectListFragmentModule;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectTabBean;
import com.dashingqi.wanandroidqi.presenter.project.ProjectListPresenter;
import com.dashingqi.wanandroidqi.view.MainActivity;

import java.util.List;

import javax.inject.Inject;

public class ProjectListFragment extends BaseLoadingFragment<ProjectListPresenter> implements ProjectContract.View {

    @Inject
    protected ProjectListPresenter mProjectListPresenter;


    @Override
    public ProjectListPresenter getPresenter() {
        return mProjectListPresenter;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void inject() {
        ((MainActivity) mActivity)
                .getComponent()
                .getProjectListFragmentComponent(new ProjectListFragmentModule())
                .inject(this);

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void showProjectData(String data) {

    }

    @Override
    public void showProjectTabData(List<ProjectTabBean> data) {

    }

    @Override
    protected void initView() {
        super.initView();
    }
}
