package com.dashingqi.wanandroidqi.di.component.fragment.wx;

import com.dashingqi.wanandroidqi.di.module.wechat.WeChatArticleListModule;
import com.dashingqi.wanandroidqi.view.wechat.WeChatArticlesListFragment;

import dagger.Subcomponent;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.di.component.fragment.wx
 * @ClassName: WeChatArticlesListComponent
 * @Author: DashingQI
 * @CreateDate: 2019-06-19 21:49
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-19 21:49
 * @UpdateRemark:
 * @Version: 1.0
 */
@Subcomponent(modules = WeChatArticleListModule.class)
public interface WeChatArticlesListComponent {

    void inject(WeChatArticlesListFragment weChatArticlesListFragment);
}
