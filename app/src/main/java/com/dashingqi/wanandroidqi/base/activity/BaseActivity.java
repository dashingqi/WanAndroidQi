package com.dashingqi.wanandroidqi.base.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dashingqi.wanandroidqi.base.view.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.basic.activity
 * @ClassName: BaseActivity
 * @Author: DashingQI
 * @CreateDate: 2019/5/11 6:25 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/11 6:25 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Unbinder mBinder;

    //初始化布局
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();

    //获取到布局的ID
    protected abstract @LayoutRes
    int getLayoutId();

    protected  abstract void inject();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mBinder = ButterKnife.bind(this);
        inject();
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBinder != null) {
            mBinder.unbind();
            mBinder = null;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_LONG).show();

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void showNormalView() {

    }
}
