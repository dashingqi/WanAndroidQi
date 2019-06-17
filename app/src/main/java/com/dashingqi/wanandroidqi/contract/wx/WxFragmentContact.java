package com.dashingqi.wanandroidqi.contract.wx;

import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.base.view.BaseView;
import com.dashingqi.wanandroidqi.network.entity.wx.WxTabData;

import java.util.List;

public interface WxFragmentContact {

    interface View extends BaseView {
        //展示微信tab数据
        void showWxTab(List<WxTabData> dataList);
    }

    interface Presenter extends IPresenter<View> {
        //获取到微信tab数据
        void getWxTabData();
    }
}
