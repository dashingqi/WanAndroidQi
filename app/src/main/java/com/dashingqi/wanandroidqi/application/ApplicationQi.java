package com.dashingqi.wanandroidqi.application;

import android.app.Application;
import android.content.Context;

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
    private static Application mApp;
    private static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        instance = getApplicationContext();

    }
}
