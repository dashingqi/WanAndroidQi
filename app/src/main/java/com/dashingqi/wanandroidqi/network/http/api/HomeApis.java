package com.dashingqi.wanandroidqi.network.http.api;

import com.dashingqi.wanandroidqi.network.entity.BaseResponse;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;
import com.dashingqi.wanandroidqi.network.entity.home.BannerDataBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.network.http.api
 * @ClassName: HomeApis
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 16:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 16:39
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface HomeApis {

    /**
     * 首页轮播图数据
     *
     * @return
     */
    @GET("banner/json")
    Observable<BaseResponse<List<BannerDataBean>>> getBannerData();

    /**
     * 获取到首页文章列表
     *
     * @param pageNum
     * @return
     */
    @GET("article/list/{pageNum}/json")
    Observable<BaseResponse<ArticlesBean>> getArticles(@Path("pageNum") int pageNum);

}
