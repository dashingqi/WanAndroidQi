package com.dashingqi.wanandroidqi.view.setting;


import android.widget.TextView;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.base.fragment.BaseFragment;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.contract.setting.SettingFragmentContract;
import com.dashingqi.wanandroidqi.presenter.setting.SettingFragmentPresenter;

import butterknife.BindView;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.view.setting
 * @ClassName: SettingFragment
 * @Author: DashingQI
 * @CreateDate: 2019/5/11 7:45 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/11 7:45 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
public class SettingFragment extends BaseLoadingFragment<SettingFragmentPresenter> implements SettingFragmentContract.View {

    @BindView(R.id.mTvSetting)
    protected TextView mTvSetting;

    private SettingFragmentPresenter mSetPresenter;

    @Override
    protected void initData() {

    }

    @Override
    public SettingFragmentPresenter getPresenter() {
        return mSetPresenter;
    }

    @Override
    protected void initView() {
        // mSetPresenter = new SettingFragmentPresenter();
       // super.initView();
    }

    @Override
    protected void loadData() {
       // mPresenter.loadSettingData();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    public void showSettingData(String data) {

        mTvSetting.setText(data);

    }

    @Override
    protected void inject() {

    }
}
