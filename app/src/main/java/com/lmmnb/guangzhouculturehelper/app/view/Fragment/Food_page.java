package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.widget.BottomBar;
import com.lmmnb.guangzhouculturehelper.app.view.widget.MyImgBtn;

public class Food_page extends Fragment {
    private View rootView;

    private MyImgBtn myImgBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.food_page,container,false);

        myImgBtn = (MyImgBtn)rootView.findViewById(R.id.camera);
        myImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Picture_Food();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction tx = fragmentManager.beginTransaction();
                tx.replace(R.id.f1,fragment);
                tx.addToBackStack(null);
                tx.commit();
            }
        });

        BottomBar bottomBar = rootView.findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#ADADAD", "#5C6BB0")
                .addItem(My.class,
                        "推荐",
                        R.drawable.facebefore,
                        R.drawable.faceafter)
                .addItem(Nothing.class,
                        "我的",
                        R.drawable.thumb_before,
                        R.drawable.thumb_after)

                .build();


        return rootView;
    }

}
