package com.dashingqi.wanandroidqi.di.module.system;

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

@Module
public class SystemArticleListModule {

    @Provides
    @PreFragment
    List<ArticleBean> provideArticleList() {
        return new ArrayList<>();
    }

    @Provides
    @PreFragment
    ArticlesAdapter provideArticleAdapter(List<ArticleBean> data) {
        return new ArticlesAdapter(R.layout.item_article_list, data);
    }

    @Provides
    @PreFragment
    LinearLayoutManager provideLienarLayoutManager() {
        return new LinearLayoutManager(ApplicationQi.getContext());
    }
}
