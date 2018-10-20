package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.lmmnb.guangzhouculturehelper.R;

public class First_Time extends Fragment {
    private View rootView;
    private Button btn;
    private CheckBox c1;
    private CheckBox c2;
    private CheckBox c3;
    private CheckBox c4;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.first_time,container,false);

        init();

        return rootView;
    }

    private void init() {

        c1 = (CheckBox) rootView.findViewById(R.id.c1);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    c1.setBackground(getResources().getDrawable(R.drawable.myshape4));
                    c1.setTextColor(getResources().getColor(R.color.white));
                }

                else
                {
                    c1.setBackground(getResources().getDrawable(R.drawable.myshape3));
                    c1.setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        c2 = (CheckBox) rootView.findViewById(R.id.c2);
        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    c2.setBackground(getResources().getDrawable(R.drawable.myshape4));
                    c2.setTextColor(getResources().getColor(R.color.white));
                }

                else
                {
                    c2.setBackground(getResources().getDrawable(R.drawable.myshape3));
                    c2.setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        c3 = (CheckBox) rootView.findViewById(R.id.c3);
        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    c3.setBackground(getResources().getDrawable(R.drawable.myshape4));
                    c3.setTextColor(getResources().getColor(R.color.white));
                }

                else
                {
                    c3.setBackground(getResources().getDrawable(R.drawable.myshape3));
                    c3.setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        c4 = (CheckBox) rootView.findViewById(R.id.c4);
        c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    c4.setBackground(getResources().getDrawable(R.drawable.myshape4));
                    c4.setTextColor(getResources().getColor(R.color.white));
                }

                else
                {
                    c4.setBackground(getResources().getDrawable(R.drawable.myshape3));
                    c4.setTextColor(getResources().getColor(R.color.black));
                }
            }
        });



        btn = (Button)rootView.findViewById(R.id.nextB);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new Food_page();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.f1,fragment);
                ft.commit();
            }
        });
    }

}
