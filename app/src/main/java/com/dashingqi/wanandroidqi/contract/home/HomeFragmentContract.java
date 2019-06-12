package com.dashingqi.wanandroidqi.contract.home;

import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.base.view.BaseView;
import com.dashingqi.wanandroidqi.network.entity.home.BannerDataBean;

import java.util.List;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.contract.home
 * @ClassName: HomeFragmentContract
 * @Author: DashingQI
 * @CreateDate: 2019-05-30 19:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-30 19:59
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface HomeFragmentContract {
    interface View extends BaseView {
        //展示首页数据
        void showBannerData(List<BannerDataBean> bannerDataBeanList);

        //展示首页数据
        void showData();

        //展示更多数据
        void showMoreData();

        //下拉刷新加载数据
        void autoRefresh();

    }

    interface Presenter extends IPresenter<View> {
        //加载首页的banner数据
        void loadBannerData();

        //加载首页数据
        void loadData(int pageNum);

        //加载更多数据
        void loadMoreData( int pageNum);

    }
}
