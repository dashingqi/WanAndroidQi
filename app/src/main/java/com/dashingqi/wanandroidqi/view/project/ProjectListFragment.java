package com.dashingqi.wanandroidqi.view.project;

import android.os.Bundle;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.common.IntentParams;
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

    private int pageNum = 1;
    private int cid;


    @Override
    public ProjectListPresenter getPresenter() {
        return mProjectListPresenter;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {
        mProjectListPresenter.getListData(pageNum, cid);

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
        return R.layout.fragment_setting;
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
        getData();
    }

    /**
     * 传递数据
     *
     * @param cid
     * @return
     */
    public static ProjectListFragment newInstance(int cid) {
        ProjectListFragment projectListFragment = new ProjectListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(IntentParams.PROJECTLISTID, cid);
        projectListFragment.setArguments(bundle);
        return projectListFragment;
    }

    /**
     * 获取到数据
     */
    private void getData() {
        Bundle bundle = getArguments();
        if (bundle != null)
            cid = bundle.getInt(IntentParams.PROJECTLISTID, -1);
    }
}
