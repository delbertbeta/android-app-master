package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Comment_Item;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Comment_List_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Content3 extends Fragment {

 //   public static List<Comment_Item> list3 = new ArrayList<Comment_Item>();
    public static ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.content3,null);

        Comment_List_Adapter comment_list_adapter = new Comment_List_Adapter(getContext(),R.layout.comment_item,My.list4);
        listView = (ListView) view.findViewById(R.id.content3_list);
        listView.setAdapter(comment_list_adapter);

        return view;

    }
/*
    private void init() {
        Comment_Item comment_item = new Comment_Item("虾饺",2f,"haochi");
        Comment_Item comment_item1 = new Comment_Item("凤爪",3f,"不好出");
        list3.add(comment_item);
        list3.add(comment_item1);
    }

    */
}