package com.lmmnb.guangzhouculturehelper.app.view;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.api.apis.Language;
import com.lmmnb.guangzhouculturehelper.api.apis.Test;
import com.lmmnb.guangzhouculturehelper.app.view.Fragment.First_Time;
import com.lmmnb.guangzhouculturehelper.app.view.Fragment.First_page;
import com.lmmnb.guangzhouculturehelper.app.view.Fragment.First_page;
import com.lmmnb.guangzhouculturehelper.app.view.Fragment.Recommend;
import com.lmmnb.guangzhouculturehelper.app.view.Fragment.Welcome;
import com.lmmnb.guangzhouculturehelper.app.view.widget.ExchangeButton;
import com.lmmnb.guangzhouculturehelper.app.view.widget.MyAdapter;
import com.lmmnb.guangzhouculturehelper.app.view.widget.MyEditText;
import com.lmmnb.guangzhouculturehelper.app.view.widget.MyOption;
import com.lmmnb.guangzhouculturehelper.app.view.widget.MyText;
import com.lmmnb.guangzhouculturehelper.app.view.widget.RecordButton;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Ripple;
import com.lmmnb.guangzhouculturehelper.app.view.widget.TextAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MyOption> list = new ArrayList<MyOption>();
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private ListView lvLeftMenu;

    private Fragment fragment;

    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);

        fragment = new First_page();
        getSupportFragmentManager().beginTransaction().replace(R.id.f1,fragment).commit();

        init();
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,R.layout.option,list);
        lvLeftMenu = (ListView) findViewById(R.id.lv_left_menu);
        lvLeftMenu.setAdapter(myAdapter);
        lvLeftMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){
                    case 0:
                        mToolbar.setTitle("翻译助手");
                        fragment = new First_page();
                        mDrawerLayout.closeDrawer(Gravity.START);
                        getSupportFragmentManager().beginTransaction().replace(R.id.f1,fragment).commit();
                        break;
                    case 1:
                        mToolbar.setTitle("美食助手");
                        fragment = new First_Time();
                        mDrawerLayout.closeDrawer(Gravity.START);
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.replace(R.id.f1,fragment).commit();

                        break;

                }
            }
        });

        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle("广州文化助手");//customize the title,个性化设置title
        mToolbar.setBackgroundColor(getResources().getColor(R.color.Primary));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//show back button and make it enabled
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mActionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        mActionBarDrawerToggle.setHomeAsUpIndicator(R.mipmap.ic_launcher);//channge the icon,改变图标
        mActionBarDrawerToggle.syncState();////show the default icon and sync the DrawerToggle state,如果你想改变图标的话，这句话要去掉。这个会使用默认的三杠图标
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);//关联 drawerlayout

    }

    private void init()
    {
        MyOption o1 = new MyOption("翻译",R.drawable.ic_translate_grey_700_24dp);
        list.add(o1);
        MyOption o2 = new MyOption("美食助手",R.drawable.ic_restaurant_grey_700_24dp);
        list.add(o2);
    }

    private void translate()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = Test.getIp();
                Log.i("demo", String.format("getIp: %s", ip));

                String mandarin = "你在哪里呀？";
                String cantonese = Language.translateToCantoneseByText(mandarin).getTgtText();
                Log.i("demo", String.format("translate: %s -> %s", mandarin, cantonese));
            }
        }).start();
    }


}
