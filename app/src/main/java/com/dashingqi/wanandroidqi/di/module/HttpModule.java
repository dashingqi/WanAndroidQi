package com.dashingqi.wanandroidqi.di.module;

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
 * 全局的网络Module
 */
@Module
public class HttpModule {

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClientBuilder(){
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
        builder.addInterceptor(new LogInterceptor());
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
    HomeApis provideHomeApi(Retrofit retrofit){
        return retrofit.create(HomeApis.class);

    }

}
