package com.stef_developer.simplegeometry;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutTriangleFragment extends Fragment {

    protected MainActivity activity;
    protected ViewPagerAdapter adapter;

    protected View fragmentView;
    protected ViewPager viewPager;
    protected TabLayout tabLayout;
    protected List<String> tabTitles;
    protected List<Fragment> tabFragments;

    public TabLayoutTriangleFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleAndFragment();
        adapter = new ViewPagerAdapter(activity.getSupportFragmentManager(), tabTitles, tabFragments);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_triangle, container, false);

        viewPager = (ViewPager) fragmentView.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) fragmentView.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabTextColors(ContextCompat.getColor(activity, R.color.pure_white),
                ContextCompat.getColor(activity, R.color.pure_white));

        return fragmentView;
    }

    protected void setTitleAndFragment() {
        tabTitles = new ArrayList<String>() {{
            add("Rumus umum");
            add("Rumus ABC");
        }};
        tabFragments = new ArrayList<Fragment>() {{
            add(new Triangle1Fragment());
            add(new Triangle2Fragment());
        }};
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
    }
}
