package com.dashingqi.wanandroidqi.di.module;

import com.dashingqi.wanandroidqi.application.ApplicationQi;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.dagger2.module
 * @ClassName: AppModule
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 17:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 17:32
 * @UpdateRemark:
 * @Version: 1.0
 */
@Module
public class AppModule {
    private ApplicationQi mApp;

    public AppModule(ApplicationQi app) {
        mApp = app;
    }

    @Provides
    @Singleton
    ApplicationQi provideApp() {
        return mApp;
    }
}
