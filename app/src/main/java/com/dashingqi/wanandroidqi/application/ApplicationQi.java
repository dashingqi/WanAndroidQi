package com.dashingqi.wanandroidqi.application;

import android.app.Application;
import android.content.Context;

import com.dashingqi.wanandroidqi.di.component.AppComponent;
import com.dashingqi.wanandroidqi.di.component.DaggerAppComponent;
import com.dashingqi.wanandroidqi.di.module.AppModule;
import com.dashingqi.wanandroidqi.utils.log.CustomLogCatStrategy;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

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
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(mApp)).build();
        //配置Logger
        configLogger();
    }

    public static ApplicationQi getContext() {
        return mApp;
    }

    public static AppComponent getAppComponent() {
        if (mAppComponent != null)
            return mAppComponent;
        else return DaggerAppComponent.builder().appModule(new AppModule(mApp)).build();
    }


    /**
     * 配置Logger日志打印
     */
    private void configLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
                .logStrategy(new CustomLogCatStrategy()) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("wan_android_dashing_qi")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                //返回 true表示打印Log日志 false不打印
                return true;
            }
        });
    }
}
