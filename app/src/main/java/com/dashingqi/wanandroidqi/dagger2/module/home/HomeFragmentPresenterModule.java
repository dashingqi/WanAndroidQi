package com.dashingqi.wanandroidqi.dagger2.module.home;

import com.dashingqi.wanandroidqi.presenter.home.HomeFragmentPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.dagger2.module.home
 * @ClassName: HomeFragmentPresenterModule
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 00:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 00:23
 * @UpdateRemark:
 * @Version: 1.0
 */
@Module
public class HomeFragmentPresenterModule {
    @Provides
    public HomeFragmentPresenter provides() {
        return new HomeFragmentPresenter();
    }
}
