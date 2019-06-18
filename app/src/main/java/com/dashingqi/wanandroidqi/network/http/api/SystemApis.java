package com.dashingqi.wanandroidqi.network.http.api;

import com.dashingqi.wanandroidqi.network.entity.BaseResponse;
import com.dashingqi.wanandroidqi.network.entity.system.SystemDataBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SystemApis {

    //获取到体系数据
    @GET("tree/json")
    Observable<BaseResponse<List<SystemDataBean>>> getSystemData();
}
