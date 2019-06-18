package com.dashingqi.wanandroidqi.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * tab栏的适配器
 */
public class TabAdapter extends FragmentPagerAdapter {
    private List<String> mTabNames;
    private List<Fragment> mTabFragments;

    public TabAdapter(FragmentManager fm, List<String> tabNames, List<Fragment> tabFragments) {
        super(fm);
        mTabNames = tabNames;
        mTabFragments = tabFragments;

    }

    @Override
    public Fragment getItem(int i) {
        return mTabFragments.get(i);
    }

    @Override
    public int getCount() {
        return mTabNames.size();
    }

    @Nullable
    @Override
    public String getPageTitle(int position) {
        return mTabNames.get(position);
    }
}
