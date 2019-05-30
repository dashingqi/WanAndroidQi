package com.dashingqi.wanandroidqi.presenter.home;

import com.dashingqi.wanandroidqi.base.model.CallBack;
import com.dashingqi.wanandroidqi.base.model.DataModel;
import com.dashingqi.wanandroidqi.base.presenter.BasePresenter;
import com.dashingqi.wanandroidqi.contract.home.HomeFragmentContract;
import com.dashingqi.wanandroidqi.model.home.HomeModel;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.presenter.home
 * @ClassName: HomeFragmentPresenter
 * @Author: DashingQI
 * @CreateDate: 2019-05-30 19:57
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-30 19:57
 * @UpdateRemark: Presenter 是View与Model 的桥梁 View 通过Presenter去调用接口请求接口，Model根据接口请求返回的结果 通过BaseView来去进行UI上的交互
 * Presenter的统一封装目前就是绑定View，解绑View 和判断View是否处于绑定中，网络请求中有可能View销毁了，这是请求成功返回要去与UI交互，此时判断是否处于绑定的状态，来决定要不要去与Ui交互。
 * @Version: 1.0
 */
public class HomeFragmentPresenter extends BasePresenter<HomeFragmentContract.View> implements HomeFragmentContract.Presenter {
    @Override
    public void loadBannerData(String param) {
        //执行加载BannerData

        if (isAttachView()) {
            mView.showLoading();
            DataModel.getInstance(HomeModel.class)
                    .params(param)
                    .execute(new CallBack<String>() {

                        @Override
                        public void onSuccess(String data) {
                            mView.showBannerData(data);
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

    @Override
    public void loadData() {

    }

    @Override
    public void loadMoreData() {

    }

}
