package com.dashingqi.wanandroidqi.dagger2.component.fragment;

import com.dashingqi.wanandroidqi.view.home.HomeFragment;

import dagger.Component;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.dagger2.component.fragment
 * @ClassName: HomeFragmentComponent
 * @Author: DashingQI
 * @CreateDate: 2019-06-01 23:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-01 23:51
 * @UpdateRemark:
 * @Version: 1.0
 */
@Component
public interface HomeFragmentComponent {
    void inject(HomeFragment homeFragment);
}
