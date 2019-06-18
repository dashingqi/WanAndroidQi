package com.dashingqi.wanandroidqi.di.component.fragment.project;

import com.dashingqi.wanandroidqi.di.module.project.ProjectFragmentModule;
import com.dashingqi.wanandroidqi.di.scope.PreFragment;
import com.dashingqi.wanandroidqi.view.project.ProjectFragment;

import dagger.Subcomponent;

@PreFragment
@Subcomponent(modules = ProjectFragmentModule.class)
public interface ProjectFragmentComponent {
    void inject(ProjectFragment projectFragment);
}
