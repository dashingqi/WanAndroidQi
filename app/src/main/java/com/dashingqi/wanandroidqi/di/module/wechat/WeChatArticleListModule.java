package com.dashingqi.wanandroidqi.di.module.wechat;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;

import com.dashingqi.wanandroidqi.application.ApplicationQi;
import com.dashingqi.wanandroidqi.network.entity.home.ArticleBean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.di.module.wechat
 * @ClassName: WeChatArticleListModule
 * @Author: DashingQI
 * @CreateDate: 2019-06-19 21:49
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-19 21:49
 * @UpdateRemark:
 * @Version: 1.0
 */
@Module
public class WeChatArticleListModule {


    @Provides
    @Named("WxArticlesLinearManager")
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(ApplicationQi.getContext());
    }

    @Provides
    @Named("WxArticleList")
    List<ArticleBean> provideArticleList() {
        return new ArrayList<>();
    }
}
