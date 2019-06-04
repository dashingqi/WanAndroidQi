package com.dashingqi.wanandroidqi.presenter.project;

import com.dashingqi.wanandroidqi.base.model.CallBack;
import com.dashingqi.wanandroidqi.base.model.DataModel;
import com.dashingqi.wanandroidqi.base.presenter.BasePresenter;
import com.dashingqi.wanandroidqi.contract.project.ProjectContract;
import com.dashingqi.wanandroidqi.model.project.ProjectModel;

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
    public ProjectPresenter(com.dashingqi.wanandroidqi.model.DataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void getProjectData() {

        if (isAttachView()) {

            mView.showLoading();

            DataModel.getInstance(ProjectModel.class)
                    .execute(new CallBack<String>() {

                        @Override
                        public void onSuccess(String data) {
                            mView.showProjectData(data);

                        }

                        @Override
                        public void onFailed(String data) {

                        }

                        @Override
                        public void onError() {

                        }

                        @Override
                        public void onComplete() {
                            mView.hideLoading();

                        }
                    });
        }

    }
}
