package com.chiigu.drawerlayoutsample.tablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by hudawei on 2016/10/9.
 */
public class TabLayoutFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] titles;
    public TabLayoutFragmentAdapter(FragmentManager fm, List<Fragment> fragments,String[] titles) {
        super(fm);
        this.fragments=fragments;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments==null?0:fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
