package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.MainActivity2;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Label_Item;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Label_List_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Content2 extends Fragment {
 //   public static List<Label_Item> list2 = new ArrayList<Label_Item>();
    public static ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.content2,null);

        Label_List_Adapter label_list_adapter = new Label_List_Adapter(getContext(),R.layout.label_item,My.list3);
        listView = (ListView) view.findViewById(R.id.content2_list);
        listView.setDividerHeight(0);
        listView.setAdapter(label_list_adapter);

        return view;

    }
/*
    private void init() {
        Label_Item label_item = new Label_Item("我喜欢");
        Label_Item label_item1 = new Label_Item("我讨厌");
        list2.add(label_item);
        list2.add(label_item1);
    }
 */
}