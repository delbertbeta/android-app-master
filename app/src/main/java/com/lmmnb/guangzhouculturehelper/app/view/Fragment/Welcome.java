package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.support.v4.app.FragmentManager;

import com.lmmnb.guangzhouculturehelper.R;

public class Welcome extends Fragment {

    private View rootView;
    private Fragment mFragment;
    private FrameLayout frameLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.welcome,container,false);
        FragmentManager fm = getActivity().getSupportFragmentManager();
        mFragment = new Food_page();
        fm.beginTransaction().replace(R.id.f3,mFragment).commit();


        return rootView;
    }
}