package com.dashingqi.wanandroidqi.model;

import com.dashingqi.wanandroidqi.network.entity.BaseResponse;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;
import com.dashingqi.wanandroidqi.network.entity.home.BannerDataBean;
import com.dashingqi.wanandroidqi.network.http.network.NetWorkHelper;
import com.dashingqi.wanandroidqi.network.http.network.NetWorkHelperImpl;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.model
 * @ClassName: DataModel
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 17:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 17:00
 * @UpdateRemark:
 * @Version: 1.0
 */
public class DataModel implements NetWorkHelper {

    private NetWorkHelper mNetWorkHelper;

    @Inject
    public DataModel(NetWorkHelperImpl netWorkHelper) {
        mNetWorkHelper = netWorkHelper;
    }

    @Override
    public Observable<BaseResponse<List<BannerDataBean>>> getBannerData() {
        return mNetWorkHelper.getBannerData();
    }

    @Override
    public Observable<BaseResponse<ArticlesBean>> getHomeArticles(int pageNum) {
        return mNetWorkHelper.getHomeArticles(pageNum);
    }

}
