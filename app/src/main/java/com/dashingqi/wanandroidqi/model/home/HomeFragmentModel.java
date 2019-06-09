package com.dashingqi.wanandroidqi.model.home;

import com.dashingqi.wanandroidqi.di.scope.PreFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.model.home
 * @ClassName: HomeFragmentModel
 * @Author: DashingQI
 * @CreateDate: 2019-06-03 23:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-03 23:26
 * @UpdateRemark:
 * @Version: 1.0
 */
@Module
public class HomeFragmentModel {

    @Provides
    @PreFragment
    @Named("bannerTitles")
    public List<String> provideBannerTitles() {
        return new ArrayList<>();
    }

    @Provides
    @PreFragment
    @Named("bannerImages")
    public List<String> provideBannerImages() {
        return new ArrayList<>();
    }

    @Provides
    @PreFragment
    @Named("bannerUrls")
    public List<String> provideBannerUrls() {
        return new ArrayList<>();
    }
}
