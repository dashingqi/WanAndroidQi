package com.dashingqi.wanandroidqi.model;

import com.dashingqi.wanandroidqi.network.entity.BaseResponse;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;
import com.dashingqi.wanandroidqi.network.entity.home.BannerDataBean;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectTabBean;
import com.dashingqi.wanandroidqi.network.entity.system.SystemDataBean;
import com.dashingqi.wanandroidqi.network.entity.wx.WxTabData;
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
    //该DataModel在AppComponent有提供方法 需要使用@Inject 该DataModule
    //带有参数 如果这个参数不能被@Inject标注，可以在@Moudle使用@Provides进行提供
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

    @Override
    public Observable<BaseResponse<List<WxTabData>>> getWxTabListData() {
        return mNetWorkHelper.getWxTabListData();
    }

    @Override
    public Observable<BaseResponse<List<SystemDataBean>>> getSystemData() {
        return mNetWorkHelper.getSystemData();
    }

    @Override
    public Observable<BaseResponse<List<ProjectTabBean>>> getProjectTabData() {
        return mNetWorkHelper.getProjectTabData();
    }

    @Override
    public Observable<BaseResponse<ArticlesBean>> getWeChatArticlesListData(int id, int pageNum) {
        return mNetWorkHelper.getWeChatArticlesListData(id, pageNum);
    }

}
