package com.dashingqi.wanandroidqi.network.http.network;

import com.dashingqi.wanandroidqi.network.entity.BaseResponse;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;
import com.dashingqi.wanandroidqi.network.entity.home.BannerDataBean;
import com.dashingqi.wanandroidqi.network.entity.wx.WxTabData;
import com.dashingqi.wanandroidqi.network.http.api.HomeApis;
import com.dashingqi.wanandroidqi.network.http.api.WxApis;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.network.http.network
 * @ClassName: NetWorkHelperImpl
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 16:38
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 16:38
 * @UpdateRemark:
 * @Version: 1.0
 */
public class NetWorkHelperImpl implements NetWorkHelper {
    private HomeApis mHomeApis;
    private WxApis mWxApis;


    @Inject
    //这个HomeApis在HttpModule中 有使用@Provides来提供获取
    public NetWorkHelperImpl(HomeApis homeApis, WxApis wxApis) {
        mHomeApis = homeApis;
        mWxApis = wxApis;
    }

    /**
     * 获取到首页Banner数据
     *
     * @return
     */
    @Override
    public Observable<BaseResponse<List<BannerDataBean>>> getBannerData() {
        return mHomeApis.getBannerData();
    }

    /**
     * 获取到首页文章的数据
     *
     * @param pageNum
     * @return
     */
    @Override
    public Observable<BaseResponse<ArticlesBean>> getHomeArticles(int pageNum) {
        return mHomeApis.getArticles(pageNum);
    }

    /**
     * 获取到微信公众号tab数据
     * @return
     */
    @Override
    public Observable<BaseResponse<List<WxTabData>>> getWxTabListData() {
        return mWxApis.getWxTabData();
    }
}
