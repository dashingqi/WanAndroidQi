package com.dashingqi.wanandroidqi.di.module.wx;

import android.support.v4.app.Fragment;

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
    @Named("WxTabFragmentList")
    List<Fragment> provideWxTabFragmentList() {
        return new ArrayList<>();
    }

}
