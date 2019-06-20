package com.dashingqi.wanandroidqi.view.project;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.adapter.TabAdapter;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.contract.project.ProjectContract;
import com.dashingqi.wanandroidqi.di.module.project.ProjectFragmentModule;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectTabBean;
import com.dashingqi.wanandroidqi.presenter.project.ProjectPresenter;
import com.dashingqi.wanandroidqi.view.MainActivity;
import com.dashingqi.wanandroidqi.view.setting.SettingFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.view.project
 * @ClassName: ProjectFragment
 * @Author: DashingQI
 * @CreateDate: 2019/5/11 7:44 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/11 7:44 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ProjectFragment extends BaseLoadingFragment<ProjectPresenter> implements ProjectContract.View {

    @BindView(R.id.mProjectViewPager)
    protected ViewPager mViewPager;

    @BindView(R.id.mSlidingTabLayout)
    protected SlidingTabLayout mSlidingTabLayout;

    @Inject
    protected ProjectPresenter mProjectPresenter;

    @Inject
    @Named("ProjectTabName")
    protected List<String> mProjectNameList;

    @Inject
    @Named("ProjectTabFragment")
    protected List<Fragment> mProjectTabFragment;

    @Inject
    @Named("ProjectTabId")
    protected List<Integer> mProjectTabId;

    @Override
    protected void initData() {

    }

    @Override
    public ProjectPresenter getPresenter() {
        return mProjectPresenter;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void loadData() {
        mProjectPresenter.getProjectTabData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    public void showProjectData(String data) {

    }

    /**
     * 展示Tab数据
     */
    @Override
    public void showProjectTabData(List<ProjectTabBean> data) {
        for (ProjectTabBean tabBean : data) {
            mProjectNameList.add(tabBean.getName());
            mProjectTabId.add(tabBean.getId());
        }
        for (int i = 0; i < mProjectTabId.size(); i++) {
            mProjectTabFragment.add(ProjectListFragment.newInstance(mProjectTabId.get(i)));
        }

        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager(), mProjectNameList, mProjectTabFragment);
        mViewPager.setAdapter(tabAdapter);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    @Override
    protected void inject() {
        ((MainActivity) mActivity)
                .getComponent()
                .getProjectFragmentComponent(new ProjectFragmentModule())
                .inject(this);
    }
}
