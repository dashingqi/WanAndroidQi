package com.dashingqi.wanandroidqi.di.component.fragment.system;

import com.dashingqi.wanandroidqi.di.component.AppComponent;
import com.dashingqi.wanandroidqi.di.module.system.SystemArticleListModule;
import com.dashingqi.wanandroidqi.di.scope.PreFragment;
import com.dashingqi.wanandroidqi.view.system.SystemArticleFragment;

import dagger.Component;

@PreFragment
@Component(dependencies = AppComponent.class, modules = SystemArticleListModule.class)
public interface SystemArticleListComponent {

    void inject(SystemArticleFragment mSystemArticleFragment);
}
