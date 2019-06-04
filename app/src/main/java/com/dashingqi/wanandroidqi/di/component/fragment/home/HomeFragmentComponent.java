package com.dashingqi.wanandroidqi.di.component.fragment.home;

import com.dashingqi.wanandroidqi.di.scope.PreFragment;
import com.dashingqi.wanandroidqi.model.home.HomeFragmentModel;
import com.dashingqi.wanandroidqi.view.home.HomeFragment;

import dagger.Subcomponent;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.dagger2.component.fragment.home
 * @ClassName: HomeFragmentComponent
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 21:21
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 21:21
 * @UpdateRemark:home的注射器
 * @Version: 1.0
 */
@PreFragment
@Subcomponent(modules = HomeFragmentModel.class)
public interface HomeFragmentComponent {
    void inject(HomeFragment homeFragment);
}
