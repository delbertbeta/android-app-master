package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.MainActivity2;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Food_Item;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Food_List_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Content1 extends Fragment {

//    private static List<Food_Item> list = new ArrayList<Food_Item>();

    public static ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.content1,null);


        Food_List_Adapter food_list_adapter = new Food_List_Adapter(getContext(),R.layout.want_item,My.list2);
        listView  = (ListView) view.findViewById(R.id.content1_list);
        listView.setAdapter(food_list_adapter);

        return view;

    }
/*
    private void init() {

        Food_Item food_item = new Food_Item("虾饺",R.drawable.cover,1f,"我想转专业",true,"没事","美食");
        list.add(food_item);
        Food_Item food_item1 = new Food_Item("凤爪",R.drawable.cover,2f,"我要崩溃了",true,"quit","test");
        list.add(food_item1);
    }

*/
}