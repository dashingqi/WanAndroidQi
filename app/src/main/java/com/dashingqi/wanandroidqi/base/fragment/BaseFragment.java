package com.dashingqi.wanandroidqi.base.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dashingqi.wanandroidqi.base.view.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.basic.fragment
 * @ClassName: BaseFragment
 * @Author: DashingQI
 * @CreateDate: 2019/5/11 6:30 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/11 6:30 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseFragment extends BaseLazyFragment implements BaseView {

    protected Activity mActivity;
    private View mView;
    private Unbinder mBinder;

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void loadData();

    protected abstract void inject();

    protected abstract @LayoutRes
    int getLayoutId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), container, false);
        mBinder = ButterKnife.bind(this, mView);
        inject();
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBinder != null) {
            mBinder.unbind();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mActivity, "msg", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNormalView() {

    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void lazyLoadData() {
        loadData();
    }
}
