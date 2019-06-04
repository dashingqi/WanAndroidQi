package com.dashingqi.wanandroidqi.presenter.main;

import com.dashingqi.wanandroidqi.base.presenter.BasePresenter;
import com.dashingqi.wanandroidqi.contract.main.MainContract;
import com.dashingqi.wanandroidqi.model.DataModel;

import javax.inject.Inject;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.presenter.main
 * @ClassName: MainPresenter
 * @Author: DashingQI
 * @CreateDate: 2019-05-29 14:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-29 14:59
 * @UpdateRemark:
 * @Version: 1.0
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {


    public MainPresenter(DataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void checkApkVersion() {

    }
}
