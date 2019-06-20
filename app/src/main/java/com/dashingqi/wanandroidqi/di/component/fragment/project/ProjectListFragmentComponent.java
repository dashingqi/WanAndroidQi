package com.dashingqi.wanandroidqi.di.component.fragment.project;

import com.dashingqi.wanandroidqi.di.module.project.ProjectListFragmentModule;
import com.dashingqi.wanandroidqi.di.scope.PreFragment;
import com.dashingqi.wanandroidqi.view.project.ProjectListFragment;

import dagger.Subcomponent;

@PreFragment
@Subcomponent(modules = ProjectListFragmentModule.class)
public interface ProjectListFragmentComponent {
    void inject(ProjectListFragment mProjectListFragment);
}
