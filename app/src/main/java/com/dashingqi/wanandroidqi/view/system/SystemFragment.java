package com.dashingqi.wanandroidqi.view.system;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.adapter.SystemListAdapter;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.contract.system.SystemFragmentContract;
import com.dashingqi.wanandroidqi.di.module.system.SystemFragmentModule;
import com.dashingqi.wanandroidqi.network.entity.system.SystemChildrenDataBean;
import com.dashingqi.wanandroidqi.network.entity.system.SystemDataBean;
import com.dashingqi.wanandroidqi.presenter.system.SystemFragmentPresenter;
import com.dashingqi.wanandroidqi.view.MainActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.view.system
 * @ClassName: SystemFragment
 * @Author: DashingQI
 * @CreateDate: 2019/5/11 7:45 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/11 7:45 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
public class SystemFragment extends BaseLoadingFragment<SystemFragmentPresenter> implements SystemFragmentContract.View {
    private static final String TAG = "SystemFragment";

    @Inject
    protected SystemFragmentPresenter mSystemFragmentPresenter;

    @Inject
    protected LinearLayoutManager mLinearLayoutManager;

    @Inject
    protected List<SystemDataBean> systemDataList;

    @Inject
    protected List<String> tabNamesList;

    @Inject
    protected List<Integer> tabIdsList;

    @Inject
    protected SystemListAdapter mSystemListAdapter;

    @BindView(R.id.mRecyclerView)
    protected RecyclerView mRecyclerView;

    @BindView(R.id.mSmartRefreshLayout)
    protected SmartRefreshLayout mSmartRefreshLayout;

    @Override
    protected void initData() {

    }

    @Override
    public SystemFragmentPresenter getPresenter() {
        return mSystemFragmentPresenter;
    }

    @Override
    protected void initView() {
        super.initView();
        initRecyclerView();
        initRefreshLayoutView();

    }

    @Override
    protected void loadData() {
        mSystemFragmentPresenter.getSystemData();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_system;
    }

    @Override
    protected void inject() {
        ((MainActivity) mActivity)
                .getComponent()
                .getSystemFragmentComponent(new SystemFragmentModule())
                .inject(this);

    }

    @Override
    public void showSystemData(List<SystemDataBean> data) {
        //获取到知识体系的数据
        Log.d(TAG, "size = " + data.size());
        for (SystemDataBean dataBean : data) {
            systemDataList.add(dataBean);
        }

        mSystemListAdapter.notifyDataSetChanged();
    }

    /**
     * 初始化RefreshLayout
     */
    private void initRefreshLayoutView() {
        //设置不能上滑加载更多。
        mSmartRefreshLayout.setEnableLoadMore(false);
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mSystemListAdapter);

        mSystemListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                tabNamesList.clear();
                tabIdsList.clear();
                for (SystemChildrenDataBean systemChildrenDataBean : systemDataList.get(position).getChildren()) {
                    tabNamesList.add(systemChildrenDataBean.getName());
                    tabIdsList.add(systemChildrenDataBean.getId());
                }
                SystemArticleActivity.startActivityByFragment(mActivity,
                        systemDataList.get(position).getName(),
                        tabNamesList,
                        tabIdsList
                );
            }
        });
    }
}
