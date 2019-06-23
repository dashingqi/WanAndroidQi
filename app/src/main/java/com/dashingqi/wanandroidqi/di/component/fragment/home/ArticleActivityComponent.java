package com.dashingqi.wanandroidqi.di.component.fragment.home;

import com.dashingqi.wanandroidqi.di.component.AppComponent;
import com.dashingqi.wanandroidqi.di.module.AppModule;
import com.dashingqi.wanandroidqi.di.scope.PreActivity;
import com.dashingqi.wanandroidqi.view.home.ArticleDetailActivity;

import dagger.Component;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.di.component.fragment.home
 * @ClassName: ArticleActivityComponent
 * @Author: DashingQI
 * @CreateDate: 2019-06-23 19:21
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-23 19:21
 * @UpdateRemark:
 * @Version: 1.0
 */
@PreActivity
@Component(dependencies = AppComponent.class)
public interface ArticleActivityComponent {

    void inject(ArticleDetailActivity mArticleDetailActivity);
}
