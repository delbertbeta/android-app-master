package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Comment_Item;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Food_Item;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Label_Item;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Recommend_Adapter;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Recommend_item;

import java.util.ArrayList;
import java.util.List;

public class My extends Fragment {
    private View rootView;

    public List<Recommend_item> list1 = new ArrayList<Recommend_item>();
    public static List<Food_Item> list2 = new ArrayList<Food_Item>();
    public static List<Label_Item> list3 = new ArrayList<Label_Item>();
    public static List<Comment_Item> list4 = new ArrayList<Comment_Item>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.my,container,false);

        init();
        Recommend_Adapter recommend_adapter = new Recommend_Adapter(getContext(),R.layout.recommend_item,list1);
        ListView l = (ListView) rootView.findViewById(R.id.recommend_list);
        l.setAdapter(recommend_adapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 0:
                        Fragment fragment = new Food_Detail();
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction tx = fragmentManager.beginTransaction();
                        tx.replace(R.id.f1,fragment);
                        tx.addToBackStack(null);
                        tx.commit();
                }
            }
        });

        return rootView;
    }

    private void init() {
        Recommend_item r1 = new Recommend_item("肥宅快乐",R.drawable.ic_launcher_background,3f,"这也是一个简介","b1","b2");
        Recommend_item r2 = new Recommend_item("脉动",R.drawable.ic_launcher_background,4f,"这也是一个简介","b1","b2");

        list1.add(r1);
        list1.add(r2);

        Food_Item food_item = new Food_Item("虾饺",R.drawable.cover,1f,"我想转专业",true,"没事","美食");
        list2.add(food_item);
        Food_Item food_item1 = new Food_Item("凤爪",R.drawable.cover,2f,"我要崩溃了",true,"quit","test");
        list2.add(food_item1);

        Label_Item label_item = new Label_Item("我喜欢");
        Label_Item label_item1 = new Label_Item("我讨厌");
        list3.add(label_item);
        list3.add(label_item1);

        Comment_Item comment_item = new Comment_Item("虾饺",2f,"haochi");
        Comment_Item comment_item1 = new Comment_Item("凤爪",3f,"不好出");
        list4.add(comment_item);
        list4.add(comment_item1);
    }


}