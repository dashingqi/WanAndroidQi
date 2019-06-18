package com.dashingqi.wanandroidqi.di.module.project;


import android.support.v4.app.Fragment;

import com.dashingqi.wanandroidqi.adapter.TabAdapter;
import com.dashingqi.wanandroidqi.di.scope.PreFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ProjectFragmentModule {

    @PreFragment
    @Provides
    @Named("ProjectTabName")
    List<String> provideProjectTabData() {
        return new ArrayList<>();
    }

    @PreFragment
    @Provides
    @Named("ProjectTabFragment")
    List<Fragment> provideProjectFragment() {
        return new ArrayList<>();
    }
}
