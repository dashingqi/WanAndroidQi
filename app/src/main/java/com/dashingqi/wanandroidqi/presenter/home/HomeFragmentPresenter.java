package com.dashingqi.wanandroidqi.presenter.home;

import android.util.Log;

import com.dashingqi.wanandroidqi.base.Observer.BaseObserver;
import com.dashingqi.wanandroidqi.base.presenter.BasePresenter;
import com.dashingqi.wanandroidqi.contract.home.HomeFragmentContract;
import com.dashingqi.wanandroidqi.event.AutoRefreshEvent;
import com.dashingqi.wanandroidqi.model.DataModel;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;
import com.dashingqi.wanandroidqi.network.entity.home.BannerDataBean;
import com.dashingqi.wanandroidqi.utils.RxBus;
import com.dashingqi.wanandroidqi.utils.RxUtil;
import com.orhanobut.logger.Logger;

import java.util.List;

import javax.inject.Inject;

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
    private static final String TAG = "HomeFragmentPresenter";

    @Inject
    public HomeFragmentPresenter(DataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void loadBannerData() {
        //执行加载BannerData
        //compose是直接对当前的Observable进行操作的。
        addRcSubScribe(
                //被观察者  getBannerData将会在Io线程发出 下文中的onNext将会在主线程中调用  [后台线程取数据，主线程显示]
                mModel.getBannerData()
                        //线程的切换
                        .compose(RxUtil.rxSchedulerHelper())
                        //结果的处理
                        .compose(RxUtil.handleResult())
                        //订阅观察者 做出反应。
                        .subscribeWith(new BaseObserver<List<BannerDataBean>>(mView, false, false) {
                            @Override
                            public void onNext(List<BannerDataBean> bannerDataBeans) {
                                super.onNext(bannerDataBeans);
                                Log.d(TAG, "size = " + bannerDataBeans.size());
                                Logger.t("banner").d(bannerDataBeans);
                                mView.showBannerData(bannerDataBeans);
                            }
                        })
        );

    }

    @Override
    public void subScribeEvent() {
        addRcSubScribe(RxBus.getInstance().toObservable(AutoRefreshEvent.class)
                .filter(autoRefreshEvent -> autoRefreshEvent.isAutoRefresh())
                .subscribe(loginEvent -> mView.autoRefresh())
        );

    }

    @Override
    public void loadData(int pageNum) {
        addRcSubScribe(
                mModel.getHomeArticles(pageNum)
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(new BaseObserver<ArticlesBean>(mView,false,false){
                    @Override
                    public void onNext(ArticlesBean articlesBean) {
                        super.onNext(articlesBean);
                        Log.d("total = ",articlesBean.getTotal()+"");

                    }
                })
        );
    }

    @Override
    public void loadMoreData(int pageNum) {

    }


}
