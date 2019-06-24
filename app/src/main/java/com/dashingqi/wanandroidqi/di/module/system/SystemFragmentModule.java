package com.dashingqi.wanandroidqi.di.module.system;

import android.support.v7.widget.LinearLayoutManager;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.adapter.SystemListAdapter;
import com.dashingqi.wanandroidqi.application.ApplicationQi;
import com.dashingqi.wanandroidqi.di.scope.PreFragment;
import com.dashingqi.wanandroidqi.network.entity.system.SystemDataBean;

import java.util.ArrayList;
import java.util.List;


import dagger.Module;
import dagger.Provides;

@Module
public class SystemFragmentModule {


    @Provides
    @PreFragment
    LinearLayoutManager providerLinearLayoutManager() {
        return new LinearLayoutManager(ApplicationQi.getContext());
    }


    @Provides
    @PreFragment
    List<SystemDataBean> provideSystemListData() {
        return new ArrayList<>();
    }

    @Provides
    @PreFragment
    List<String> provideSystemTabNameList() {
        return new ArrayList<>();
    }

    @Provides
    @PreFragment
    List<Integer> provideSystemTabIdList() {
        return new ArrayList<>();
    }

    @Provides
    @PreFragment
    SystemListAdapter provideSystemListAdapter(List<SystemDataBean> systemDataList) {
        return new SystemListAdapter(R.layout.item_system_list, systemDataList);
    }
}
