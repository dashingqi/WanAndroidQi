package com.dashingqi.wanandroidqi.presenter.wx;

import android.util.Log;

import com.dashingqi.wanandroidqi.base.Observer.BaseObserver;
import com.dashingqi.wanandroidqi.base.presenter.BasePresenter;
import com.dashingqi.wanandroidqi.contract.wx.WxFragmentContact;
import com.dashingqi.wanandroidqi.model.DataModel;
import com.dashingqi.wanandroidqi.network.entity.wx.WxTabData;
import com.dashingqi.wanandroidqi.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

public class WxFragmentPresenter extends BasePresenter<WxFragmentContact.View> implements WxFragmentContact.Presenter {
    private static final String TAG = "WxFragmentPresenter";

    @Inject
    public WxFragmentPresenter(DataModel dataModel) {
        super(dataModel);
    }


    @Override
    public void getWxTabData() {
        //在这里面进行数据的调用
        addRxSubScribe(
                mModel.getWxTabListData()
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribeWith(new BaseObserver<List<WxTabData>>(mView, false, false) {
                            @Override
                            public void onNext(List<WxTabData> wxTabData) {
                                super.onNext(wxTabData);
                                Log.d(TAG, wxTabData.size() + " size");
                                mView.showWxTab(wxTabData);
                            }
                        })
        );
    }
}
