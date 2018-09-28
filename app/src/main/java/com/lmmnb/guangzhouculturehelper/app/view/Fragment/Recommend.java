package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.widget.BottomBar;
import com.lmmnb.guangzhouculturehelper.app.view.widget.MyImgBtn;

public class Recommend extends Fragment {
    private View rootView;

    private MyImgBtn myImgBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.empty,container,false);

        myImgBtn = (MyImgBtn)rootView.findViewById(R.id.camera);
        myImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"success",Toast.LENGTH_SHORT).show();
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
