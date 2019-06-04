package com.dashingqi.wanandroidqi.dagger2.component.activity;

import com.dashingqi.wanandroidqi.dagger2.scope.PreActivity;
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
@Component
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);

}
