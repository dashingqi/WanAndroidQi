package com.dashingqi.wanandroidqi.contract.project;

import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.base.view.BaseView;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectTabBean;

import java.util.List;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.contract.project
 * @ClassName: ProjectContract
 * @Author: DashingQI
 * @CreateDate: 2019-05-31 17:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-31 17:22
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface ProjectContract {

    interface View extends BaseView {
        void showProjectData(String data);

        void showProjectTabData(List<ProjectTabBean> data);
    }

    interface Presenter extends IPresenter<View> {

        void getProjectData();

        void getProjectTabData();


    }
}
