package com.dashingqi.wanandroidqi.network.http.api;

import com.dashingqi.wanandroidqi.network.entity.BaseResponse;
import com.dashingqi.wanandroidqi.network.entity.wx.WxTabData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface WxApis {

    /**
     * 获取到微信tab列表数据
     *
     * @return
     */
    @GET("wxarticle/chapters/json")
    Observable<BaseResponse<List<WxTabData>>> getWxTabData();

}
