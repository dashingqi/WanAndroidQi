package com.dashingqi.wanandroidqi.di.component.activity;

import com.dashingqi.wanandroidqi.di.component.AppComponent;
import com.dashingqi.wanandroidqi.di.component.fragment.home.HomeFragmentComponent;
import com.dashingqi.wanandroidqi.di.component.fragment.project.ProjectFragmentComponent;
import com.dashingqi.wanandroidqi.di.component.fragment.system.SystemFragmentComponent;
import com.dashingqi.wanandroidqi.di.component.fragment.wx.WeChatArticlesListComponent;
import com.dashingqi.wanandroidqi.di.component.fragment.wx.WxFragmentComponent;
import com.dashingqi.wanandroidqi.di.module.project.ProjectFragmentModule;
import com.dashingqi.wanandroidqi.di.module.home.HomeFragmentModule;
import com.dashingqi.wanandroidqi.di.module.main.MainActivityModule;
import com.dashingqi.wanandroidqi.di.module.system.SystemFragmentModule;
import com.dashingqi.wanandroidqi.di.module.wechat.WeChatArticleListModule;
import com.dashingqi.wanandroidqi.di.module.wx.WxFragmentModule;
import com.dashingqi.wanandroidqi.di.scope.PreActivity;
import com.dashingqi.wanandroidqi.view.MainActivity;

import dagger.Component;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.dagger2.component.activity
 * @ClassName: MainActivityComponent
 * @Author: DashingQI
 * @CreateDate: 2019-06-03 21:09
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-03 21:09
 * @UpdateRemark:
 * @Version: 1.0
 */
@PreActivity
@Component(dependencies = AppComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);

    HomeFragmentComponent getHomeFragmentComponent(HomeFragmentModule homeFragmentModel);

    WxFragmentComponent getWxFragmentComponent(WxFragmentModule wxFragmentModule);

    SystemFragmentComponent getSystemFragmentComponent(SystemFragmentModule systemFragmentModule);

    ProjectFragmentComponent getProjectFragmentComponent(ProjectFragmentModule projectFragmentModule);

    WeChatArticlesListComponent getWeChatArticlesListComponent(WeChatArticleListModule weChatArticleListModule);
}
