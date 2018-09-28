package com.lmmnb.guangzhouculturehelper.app.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.Fragment.Nothing;
import com.lmmnb.guangzhouculturehelper.app.view.widget.BottomBar;
import com.lmmnb.guangzhouculturehelper.app.view.Fragment.My;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty);

        BottomBar bottomBar = findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                .addItem(My.class,
                        "首页",
                        R.drawable.facebefore,
                        R.drawable.faceafter)
                .addItem(Nothing.class,
                        "订单",
                        R.drawable.thumb_before,
                        R.drawable.thumb_after)

                .build();



    }

}
