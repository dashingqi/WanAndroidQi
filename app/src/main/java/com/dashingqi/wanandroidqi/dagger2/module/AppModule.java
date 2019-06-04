package com.dashingqi.wanandroidqi.dagger2.module;

import com.dashingqi.wanandroidqi.application.ApplicationQi;
import com.dashingqi.wanandroidqi.common.Constant;
import com.dashingqi.wanandroidqi.network.http.api.HomeApis;

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

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        //配置网络
        File cacheDir = new File(Constant.BASE_URL);
        Cache cache = new Cache(cacheDir, 1024 * 1024 * 5); //缓存大小为5m
        builder.cache(cache);

        //错误重连
        builder.retryOnConnectionFailure(true);
        //设置超时时间
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);

        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    HomeApis provideHomeApis(Retrofit retrofit) {
        return retrofit.create(HomeApis.class);
    }
}
