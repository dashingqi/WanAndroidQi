package com.dashingqi.wanandroidqi.di.module.home;

import android.support.v7.widget.LinearLayoutManager;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.adapter.ArticlesAdapter;
import com.dashingqi.wanandroidqi.application.ApplicationQi;
import com.dashingqi.wanandroidqi.di.scope.PreFragment;
import com.dashingqi.wanandroidqi.network.entity.home.ArticleBean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.dagger2.module.home
 * @ClassName: HomeFragmentModule
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 21:21
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 21:21
 * @UpdateRemark:
 * @Version: 1.0
 */
@Module
public class HomeFragmentModule {


    @Provides
    @PreFragment
    @Named("bannerTitles")
    public List<String> provideBannerTitles() {
        return new ArrayList<>();
    }

    @Provides
    @PreFragment
    @Named("bannerImages")
    public List<String> provideBannerImages() {
        return new ArrayList<>();
    }

    @Provides
    @PreFragment
    @Named("bannerUrls")
    public List<String> provideBannerUrls() {
        return new ArrayList<>();
    }

    @Provides
    @PreFragment
    public List<ArticleBean> provideArticleList() {
        return new ArrayList<>();
    }

    @Provides
    @PreFragment
    public ArticlesAdapter provideArticleAdapter(List<ArticleBean> data) {
        return new ArticlesAdapter(R.layout.item_article_list, data);
    }

    @Provides
    @PreFragment
    public LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(ApplicationQi.getContext());
    }
}
