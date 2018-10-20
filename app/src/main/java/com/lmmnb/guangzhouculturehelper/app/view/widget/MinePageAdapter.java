package com.lmmnb.guangzhouculturehelper.app.view.widget;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lmmnb.guangzhouculturehelper.app.view.Fragment.Content1;
import com.lmmnb.guangzhouculturehelper.app.view.Fragment.Content2;
import com.lmmnb.guangzhouculturehelper.app.view.Fragment.Content3;

/**
 * Created by 76952 on 2018/9/29.
 */

public class MinePageAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"想吃", "标签", "吃过"};

    public MinePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Content1();
        } else if (position == 1) {
            return new Content2();
        }else if (position == 2) {
            return new Content3();
        }
        return new Content1();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }
}
