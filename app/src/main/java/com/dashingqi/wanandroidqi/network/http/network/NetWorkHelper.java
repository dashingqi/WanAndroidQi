package com.dashingqi.wanandroidqi.network.http.network;

import com.dashingqi.wanandroidqi.network.entity.BaseResponse;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;
import com.dashingqi.wanandroidqi.network.entity.home.BannerDataBean;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectListBean;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectTabBean;
import com.dashingqi.wanandroidqi.network.entity.system.SystemDataBean;
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

    //获取到体系数据
    Observable<BaseResponse<List<SystemDataBean>>> getSystemData();

    //获取到项目的tab数据
    Observable<BaseResponse<List<ProjectTabBean>>> getProjectTabData();

    //获取到微信公众号对应的文章列表数据
    Observable<BaseResponse<ArticlesBean>> getWeChatArticlesListData(int id, int pageNum);

    //获取到项目列表数据
    Observable<BaseResponse<ProjectListBean>> getProjectListData(int pageNum, int cid);

    //获取到知识体系下的文章
    Observable<BaseResponse<ArticlesBean>> getArticlesListData(int pageNum, int cid);
}
