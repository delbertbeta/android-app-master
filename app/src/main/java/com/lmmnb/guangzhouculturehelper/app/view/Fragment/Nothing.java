package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.widget.MinePageAdapter;

public class Nothing extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabLayout.Tab tag;
    private TabLayout.Tab want;
    private TabLayout.Tab ate;
    private MinePageAdapter minePagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.nothing,null);

        viewPager = (ViewPager)view.findViewById(R.id.view_pager);
        minePagerAdapter = new MinePageAdapter(getChildFragmentManager());
        viewPager.setAdapter(minePagerAdapter);

        tabLayout = (TabLayout)view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        tag = tabLayout.getTabAt(0);
        want = tabLayout.getTabAt(1);
        ate = tabLayout.getTabAt(2);

        return view;

    }
}