package com.dashingqi.wanandroidqi.presenter.system;

import android.util.Log;

import com.dashingqi.wanandroidqi.base.Observer.BaseObserver;
import com.dashingqi.wanandroidqi.base.presenter.BasePresenter;
import com.dashingqi.wanandroidqi.contract.system.SystemContract;
import com.dashingqi.wanandroidqi.model.DataModel;
import com.dashingqi.wanandroidqi.network.entity.system.SystemDataBean;
import com.dashingqi.wanandroidqi.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

public class SystemFragmentPresenter extends BasePresenter<SystemContract.View> implements SystemContract.Presenter {
    private static final String TAG = "SystemFragmentPresenter";

    @Inject
    public SystemFragmentPresenter(DataModel dataModel) {
        super(dataModel);
    }


    @Override
    public void getSystemData() {
        //在这里调用接口请求数据
        addRxSubScribe(
                mModel.getSystemData()
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribeWith(new BaseObserver<List<SystemDataBean>>(mView, false, false) {
                            @Override
                            public void onNext(List<SystemDataBean> systemDataBeans) {
                                super.onNext(systemDataBeans);
                                Log.d(TAG, "size = " + systemDataBeans.size());
                            }
                        })
        );

    }
}
