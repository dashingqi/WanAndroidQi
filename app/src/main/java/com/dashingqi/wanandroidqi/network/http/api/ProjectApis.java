package com.dashingqi.wanandroidqi.network.http.api;

import com.dashingqi.wanandroidqi.network.entity.BaseResponse;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectListBean;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectTabBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProjectApis {

    //获取到项目的tab栏数据
    @GET("project/tree/json")
    Observable<BaseResponse<List<ProjectTabBean>>> getProjectTabBean();

    //获取到项目列表数据
    @GET("project/list/{pageNum}/json")
    Observable<BaseResponse<ProjectListBean>> getProjectListData(@Path("pageNum") int pageNum, @Query("cid") int cid);
}
