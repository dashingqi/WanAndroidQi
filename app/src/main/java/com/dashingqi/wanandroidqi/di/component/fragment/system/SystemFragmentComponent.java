package com.dashingqi.wanandroidqi.di.component.fragment.system;

import com.dashingqi.wanandroidqi.di.module.system.SystemFragmentModule;
import com.dashingqi.wanandroidqi.di.scope.PreFragment;
import com.dashingqi.wanandroidqi.view.system.SystemFragment;

import dagger.Subcomponent;

@PreFragment
@Subcomponent(modules = SystemFragmentModule.class)
public interface SystemFragmentComponent {
    void inject(SystemFragment mSystemFragment);
}
