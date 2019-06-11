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
//@Component是@Inject和@Module的桥梁 是将两者连接起来的桥梁。
//@Component中提供的方法 如果是void 必须有注入的对象环境
//如果是参数为空 并且具有返回值类型的，那么返回值类型对应类的构造方法必须被@Inject标注或者在引用的
//Module中有@Provides提供
public interface AppComponent {
    //注入Application
    void inject(ApplicationQi applicationQi);


    ApplicationQi getApp();

    DataModel getDataModel();

}
