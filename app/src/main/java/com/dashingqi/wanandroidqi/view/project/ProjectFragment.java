package com.dashingqi.wanandroidqi.view.project;


import android.widget.TextView;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.base.fragment.BaseFragment;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.contract.project.ProjectContract;
import com.dashingqi.wanandroidqi.presenter.main.MainPresenter;
import com.dashingqi.wanandroidqi.presenter.project.ProjectPresenter;

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

    @BindView(R.id.mTvText)
    protected TextView mTvText;

    private ProjectPresenter mProjectPresenter;

    @Override
    protected void initData() {

    }

    @Override
    public ProjectPresenter getPresenter() {
        return mProjectPresenter;
    }

    @Override
    protected void initView() {
        //mProjectPresenter = new ProjectPresenter();
       // super.initView();
    }

    @Override
    protected void loadData() {
        //mProjectPresenter.getProjectData();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    public void showProjectData(String data) {
        mTvText.setText(data);

    }

    @Override
    protected void inject() {

    }
}
