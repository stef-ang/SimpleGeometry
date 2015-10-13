package com.stef_developer.simplegeometry;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by stef_ang on 10/12/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<String> titles;
    private List<Fragment> fragments;
    String[] title = new String[]{
            "Laporan Saya", "Laporan Team"
    };

    public ViewPagerAdapter(FragmentManager manager, List<String> titleList, List<Fragment> fragmentList) {
        super(manager);
        titles = titleList;
        fragments = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }
}

