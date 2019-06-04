package com.dashingqi.wanandroidqi.view;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.base.activity.BasePresenterActivity;
import com.dashingqi.wanandroidqi.base.fragment.BaseFragment;
import com.dashingqi.wanandroidqi.contract.main.MainContract;
import com.dashingqi.wanandroidqi.dagger2.component.activity.DaggerMainActivityComponent;
import com.dashingqi.wanandroidqi.dagger2.component.activity.MainActivityComponent;
import com.dashingqi.wanandroidqi.presenter.main.MainPresenter;
import com.dashingqi.wanandroidqi.view.home.HomeFragment;
import com.dashingqi.wanandroidqi.view.project.ProjectFragment;
import com.dashingqi.wanandroidqi.view.setting.SettingFragment;
import com.dashingqi.wanandroidqi.view.system.SystemFragment;
import com.dashingqi.wanandroidqi.view.wechat.WeChatFragment;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BasePresenterActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.mBottomNav)
    protected BottomNavigationView mBottomNav;

    @BindView(R.id.mContainerView)
    protected FrameLayout mContainerView;

    private BaseFragment[] mFragments = new BaseFragment[5];
    private int mPreFragmentFlag = 0;
    @Inject
    protected MainPresenter mainPresenter;

    private MainActivityComponent mMainActivityComponent;

    @Override
    public MainPresenter getPresenter() {
        return mainPresenter;
    }

    @Override
    protected void initView() {
        super.initView();
        initFragment();
        initBottomNavigateView();
    }

    private void initBottomNavigateView() {
        mBottomNav.setItemIconTintList(null);
        mBottomNav.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.home:
                    showAndHideFragment(mFragments[0], mFragments[mPreFragmentFlag]);
                    mPreFragmentFlag = 0;
                    break;
                case R.id.wechat:
                    showAndHideFragment(mFragments[1], mFragments[mPreFragmentFlag]);
                    mPreFragmentFlag = 1;
                    break;
                case R.id.project:
                    showAndHideFragment(mFragments[2], mFragments[mPreFragmentFlag]);
                    mPreFragmentFlag = 2;
                    break;
                case R.id.system:
                    showAndHideFragment(mFragments[3], mFragments[mPreFragmentFlag]);
                    mPreFragmentFlag = 3;
                    break;
                case R.id.setting:
                    showAndHideFragment(mFragments[4], mFragments[mPreFragmentFlag]);
                    mPreFragmentFlag = 4;
                    break;
            }
            return true;
        });
    }

    private void initFragment() {

        mFragments[0] = new HomeFragment();
        mFragments[1] = new WeChatFragment();
        mFragments[2] = new ProjectFragment();
        mFragments[3] = new SystemFragment();
        mFragments[4] = new SettingFragment();
        initLoadFragment(R.id.mContainerView, 0, mFragments);
    }

    /**
     * 展示或者隐藏
     *
     * @param show 要展示的Fragment
     * @param hide 要隐藏的Fragment
     */
    private void showAndHideFragment(Fragment show, Fragment hide) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (show != hide)
            transaction.show(show).hide(hide).commitAllowingStateLoss();

    }

    /**
     * 初始化状态Fragment
     *
     * @param containerId  Fragment要状态的布局
     * @param showFragment 要默认展示的Fragment
     * @param fragments    所有的Fragment
     */
    private void initLoadFragment(int containerId, int showFragment, Fragment... fragments) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < fragments.length; i++) {
            transaction.add(containerId, fragments[i], fragments[i].getClass().getName());
            //默认展示 fragments[showFragment]
            if (i != showFragment)
                transaction.hide(fragments[i]);
        }
        transaction.commitAllowingStateLoss();

    }

    @Override
    protected void initData() {


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void inject() {
        DaggerMainActivityComponent.builder().build().inject(MainActivity.this);
    }


    @Override
    public void showUpdateDialog() {

    }

    public MainActivityComponent getComponent() {
        return mMainActivityComponent;
    }
}
