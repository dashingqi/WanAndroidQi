package com.dashingqi.wanandroidqi.di.component.fragment.wx;

import com.dashingqi.wanandroidqi.di.module.wx.WxFragmentModule;
import com.dashingqi.wanandroidqi.di.scope.PreFragment;
import com.dashingqi.wanandroidqi.view.wechat.WeChatFragment;

import dagger.Subcomponent;

@PreFragment
@Subcomponent(modules = WxFragmentModule.class)
public interface WxFragmentComponent {
    void inject(WeChatFragment weChatFragment);
}
