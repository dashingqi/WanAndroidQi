package com.dashingqi.wanandroidqi.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.base.fragment
 * @ClassName: BaseLazyFragment
 * @Author: DashingQI
 * @CreateDate: 2019-06-17 23:57
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-17 23:57
 * @UpdateRemark:
 * @Version: 1.0
 */
public class BaseLazyFragment extends Fragment {
    private static final String TAG = "BaseLazyFragment";

    private boolean isViewCreated = false;
    private boolean isLoadData = false;
    private boolean isFirstVisible = true;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        isViewCreated = true;
        Log.d(TAG, "onViewCreated: ");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
        if (isFragmentVisible(this) && this.isAdded()) {
            lazyLoadData();
            isLoadData = true;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint: ");
        if (isFragmentVisible(this) && isViewCreated && this.isAdded() && !isLoadData) {
            lazyLoadData();
            isLoadData = true;

        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG, "onHiddenChanged: ");
        if (!hidden && isFirstVisible && this.isAdded()) {
            lazyLoadData();
            isFirstVisible = false;
        }
    }

    /**
     * 判断当前Fragment是否对用户可见
     *
     * @param fragment
     * @return
     */
    private boolean isFragmentVisible(Fragment fragment) {
        return !fragment.isHidden() && fragment.getUserVisibleHint();
    }

    public void lazyLoadData() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        isViewCreated = false;
        isLoadData = false;
        isFirstVisible = true;
    }
}
