package com.dashingqi.wanandroidqi.network.http.api;

import com.dashingqi.wanandroidqi.network.entity.BaseResponse;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;
import com.dashingqi.wanandroidqi.network.entity.wx.WxTabData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WxApis {

    /**
     * 获取到微信tab列表数据
     *
     * @return
     */
    @GET("wxarticle/chapters/json")
    Observable<BaseResponse<List<WxTabData>>> getWxTabData();

    /**
     * 获取到公众号对应的文章列表数据
     * @param id
     * @param pageNum
     * @return
     */
    @GET("wxarticle/list/{id}/{pageNum}/json")
    Observable<BaseResponse<ArticlesBean>> getWeChatArticlesListData(@Path("id")int id, @Path("pageNum")int pageNum);

}
