package com.dashingqi.wanandroidqi.di.module.home;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.dagger2.module.home
 * @ClassName: HomeFragmentModule
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 21:21
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 21:21
 * @UpdateRemark:
 * @Version: 1.0
 */
@Module
public class HomeFragmentModule {

    @Provides
    @Named("bannerTitles")
    public List<String> provideBannerTitles() {
        return new ArrayList<>();
    }

    @Provides
    @Named("bannerImages")
    public List<String> provideBannerImage() {
        return new ArrayList<>();
    }
}