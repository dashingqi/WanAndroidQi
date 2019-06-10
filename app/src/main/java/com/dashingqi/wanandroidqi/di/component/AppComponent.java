package com.dashingqi.wanandroidqi.di.component;

import com.dashingqi.wanandroidqi.application.ApplicationQi;
import com.dashingqi.wanandroidqi.di.module.AppModule;
import com.dashingqi.wanandroidqi.di.module.HttpModule;
import com.dashingqi.wanandroidqi.model.DataModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.dagger2.component
 * @ClassName: AppComponent
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 17:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 17:42
 * @UpdateRemark: 存放的都是公共的对象 生命周期和Application一样长
 * @Version: 1.0
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    //注入Application
    void inject(ApplicationQi applicationQi);


    ApplicationQi getApp();

    DataModel getDataModel();

}
