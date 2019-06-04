package com.dashingqi.wanandroidqi.application;

import android.app.Application;
import android.content.Context;

import com.dashingqi.wanandroidqi.dagger2.component.AppComponent;
import com.dashingqi.wanandroidqi.dagger2.component.DaggerAppComponent;
import com.dashingqi.wanandroidqi.dagger2.module.AppModule;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.Application
 * @ClassName: ApplicationQi
 * @Author: DashingQI
 * @CreateDate: 2019/5/11 6:33 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/11 6:33 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ApplicationQi extends Application {
    private static ApplicationQi mApp;
    private static Context instance;
    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        instance = getApplicationContext();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

    }

    public static ApplicationQi getContext() {
        return mApp;
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }
}
