package com.dashingqi.wanandroidqi.network.http.api;

import com.dashingqi.wanandroidqi.network.entity.BaseResponse;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;
import com.dashingqi.wanandroidqi.network.entity.system.SystemDataBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SystemApis {

    //获取到体系数据
    @GET("tree/json")
    Observable<BaseResponse<List<SystemDataBean>>> getSystemData();

    //知识体系下的文章
    @GET("article/list/{pageNum}/json")
    Observable<BaseResponse<ArticlesBean>> getArticlesList(@Path("pageNum") int pageNum, @Query("cid") int cid);
}
