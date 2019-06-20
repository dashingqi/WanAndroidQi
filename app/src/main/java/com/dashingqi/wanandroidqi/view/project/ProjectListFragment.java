package com.dashingqi.wanandroidqi.view.project;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.adapter.ProjectListAdapter;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.common.IntentParams;
import com.dashingqi.wanandroidqi.contract.project.ProjectListContract;
import com.dashingqi.wanandroidqi.di.module.project.ProjectListFragmentModule;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectListBean;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectListItemBean;
import com.dashingqi.wanandroidqi.presenter.project.ProjectListPresenter;
import com.dashingqi.wanandroidqi.view.MainActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class ProjectListFragment extends BaseLoadingFragment<ProjectListPresenter> implements ProjectListContract.View {

    @Inject
    protected ProjectListPresenter mProjectListPresenter;

    @Inject
    protected LinearLayoutManager mLinearLayoutManager;

    @Inject
    protected List<ProjectListItemBean> mProjectListBeanList;

    @Inject
    protected ProjectListAdapter mProjectListAdapter;

    @BindView(R.id.mSmartRefreshLayout)
    protected SmartRefreshLayout mSmartRefreshLayout;

    @BindView(R.id.mRecyclerView)
    protected RecyclerView mRecyclerView;

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
        return R.layout.fragment_common_artiles_list;
    }

    @Override
    protected void initView() {
        super.initView();
        getData();
        initRecyclerView();

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

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mProjectListAdapter);

    }

    @Override
    public void showListData(ProjectListBean data) {
        for (ProjectListItemBean projectListItemBean : data.getDatas()) {
            mProjectListBeanList.add(projectListItemBean);
        }
        mProjectListAdapter.notifyDataSetChanged();

    }

    @Override
    public void showMoreListData(ProjectListBean data) {

    }
}
