package com.dashingqi.wanandroidqi.di.module;

import com.dashingqi.wanandroidqi.application.ApplicationQi;
import com.dashingqi.wanandroidqi.common.Constant;
import com.dashingqi.wanandroidqi.network.http.api.HomeApis;
import com.dashingqi.wanandroidqi.network.interceptor.LogInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
