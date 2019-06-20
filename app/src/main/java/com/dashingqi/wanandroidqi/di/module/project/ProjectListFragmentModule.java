package com.dashingqi.wanandroidqi.di.module.project;

import android.support.v7.widget.LinearLayoutManager;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.adapter.ProjectListAdapter;
import com.dashingqi.wanandroidqi.application.ApplicationQi;
import com.dashingqi.wanandroidqi.di.scope.PreFragment;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectListItemBean;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class ProjectListFragmentModule {

    @Provides
    @PreFragment
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(ApplicationQi.getContext());
    }

    @PreFragment
    @Provides
    List<ProjectListItemBean> provideProjectListBeanList() {
        return new ArrayList<>();
    }

    @PreFragment
    @Provides
    ProjectListAdapter provideFragmentListAdapter(List<ProjectListItemBean> data) {
        return new ProjectListAdapter(R.layout.item_project_list, data);
    }
}
