package com.dashingqi.wanandroidqi.network.http.api;

import com.dashingqi.wanandroidqi.network.entity.BaseResponse;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectTabBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ProjectApis {

    @GET("project/tree/json")
    Observable<BaseResponse<List<ProjectTabBean>>> getProjectTabBean();
}
