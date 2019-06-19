package com.dashingqi.wanandroidqi.di.module.wx;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;

import com.dashingqi.wanandroidqi.application.ApplicationQi;
import com.dashingqi.wanandroidqi.network.entity.home.ArticleBean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class WxFragmentModule {

    @Provides
    @Named("WxTabNameList")
    List<String> provideWxTabNameList() {
        return new ArrayList<>();
    }

    @Provides
    @Named("WxTabIdList")
    List<Integer> provideExTabIdList() {
        return new ArrayList<>();
    }

    @Provides
    @Named("WxTabFragmentList")
    List<Fragment> provideWxTabFragmentList() {
        return new ArrayList<>();
    }

}
