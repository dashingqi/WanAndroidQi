package com.dashingqi.wanandroidqi.network.http.network;

import com.dashingqi.wanandroidqi.network.entity.BaseResponse;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;
import com.dashingqi.wanandroidqi.network.entity.home.BannerDataBean;
import com.dashingqi.wanandroidqi.network.entity.wx.WxTabData;

import java.util.List;

import io.reactivex.Observable;


/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.network.http.network
 * @ClassName: NetWorkHelper
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 16:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 16:04
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface NetWorkHelper {

    /**
     * home
     *
     * @return
     */

    //获取到首页轮播图的数据
    Observable<BaseResponse<List<BannerDataBean>>> getBannerData();

    //获取到首页文章
    Observable<BaseResponse<ArticlesBean>> getHomeArticles(int pageNum);

    //获取到微信公众号tab数据
    Observable<BaseResponse<List<WxTabData>>> getWxTabListData();
}
