package com.dashingqi.wanandroidqi.presenter.project;

import android.util.Log;

import com.dashingqi.wanandroidqi.base.Observer.BaseObserver;
import com.dashingqi.wanandroidqi.base.model.CallBack;
import com.dashingqi.wanandroidqi.base.model.DataModel;
import com.dashingqi.wanandroidqi.base.presenter.BasePresenter;
import com.dashingqi.wanandroidqi.contract.project.ProjectContract;
import com.dashingqi.wanandroidqi.model.project.ProjectModel;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectTabBean;
import com.dashingqi.wanandroidqi.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.presenter.project
 * @ClassName: ProjectPresenter
 * @Author: DashingQI
 * @CreateDate: 2019-05-31 17:25
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-31 17:25
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ProjectPresenter extends BasePresenter<ProjectContract.View> implements ProjectContract.Presenter {
    private static final String TAG = "ProjectPresenter";

    @Inject
    public ProjectPresenter(com.dashingqi.wanandroidqi.model.DataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void getProjectData() {
    }

    /**
     * 获取到Project的Tab数据
     */
    @Override
    public void getProjectTabData() {
        addRxSubScribe(
                mModel.getProjectTabData()
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribeWith(new BaseObserver<List<ProjectTabBean>>(mView) {
                            @Override
                            public void onNext(List<ProjectTabBean> projectTabBeans) {
                                super.onNext(projectTabBeans);
                                mView.showProjectTabData(projectTabBeans);
                            }
                        })
        );

    }
}
