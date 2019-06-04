package com.dashingqi.wanandroidqi.di.module.main;

import android.support.v4.app.Fragment;

import com.dashingqi.wanandroidqi.base.fragment.BaseFragment;
import com.dashingqi.wanandroidqi.di.scope.PreActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.dagger2.module.main
 * @ClassName: MainActivityModule
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 22:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 22:39
 * @UpdateRemark:
 * @Version: 1.0
 */
@Module
public class MainActivityModule {
    @Provides
    @PreActivity
    public Fragment[] provideFragments() {
        return new BaseFragment[5];
    }
}
