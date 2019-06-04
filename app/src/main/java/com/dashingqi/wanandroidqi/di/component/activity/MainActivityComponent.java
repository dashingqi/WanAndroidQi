package com.dashingqi.wanandroidqi.di.component.activity;

import com.dashingqi.wanandroidqi.di.component.AppComponent;
import com.dashingqi.wanandroidqi.di.component.fragment.home.HomeFragmentComponent;
import com.dashingqi.wanandroidqi.di.module.main.MainActivityModule;
import com.dashingqi.wanandroidqi.di.scope.PreActivity;
import com.dashingqi.wanandroidqi.model.home.HomeFragmentModel;
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

    HomeFragmentComponent getHomeFragmentComponent(HomeFragmentModel homeFragmentModel);
}
