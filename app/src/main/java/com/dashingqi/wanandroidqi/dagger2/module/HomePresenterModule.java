package com.dashingqi.wanandroidqi.dagger2.module;

import com.dashingqi.wanandroidqi.presenter.home.HomeFragmentPresenter;
import com.dashingqi.wanandroidqi.view.home.HomeFragment;

import dagger.Module;
import dagger.Provides;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.dagger2.fragment.home
 * @ClassName: HomePresenterModule
 * @Author: DashingQI
 * @CreateDate: 2019-06-01 23:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-01 23:43
 * @UpdateRemark:
 * @Version: 1.0
 */
@Module
public class HomePresenterModule {
    @Provides
    public HomeFragmentPresenter getHomePresenter() {
        return new HomeFragmentPresenter();
    }
}
