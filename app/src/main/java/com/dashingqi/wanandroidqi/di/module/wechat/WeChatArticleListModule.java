package com.dashingqi.wanandroidqi.di.module.wechat;

import android.support.v7.widget.LinearLayoutManager;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.adapter.ArticlesAdapter;
import com.dashingqi.wanandroidqi.application.ApplicationQi;
import com.dashingqi.wanandroidqi.di.scope.PreFragment;
import com.dashingqi.wanandroidqi.network.entity.home.ArticleBean;

import java.util.ArrayList;
import java.util.List;


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


    @PreFragment
    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(ApplicationQi.getContext());
    }

    @PreFragment
    @Provides
    List<ArticleBean> provideArticleList() {
        return new ArrayList<>();
    }

    @PreFragment
    @Provides
    ArticlesAdapter provideArticlesAdapter(List<ArticleBean> data){
        return new ArticlesAdapter(R.layout.item_article_list,data);
    }

}
