package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Recommend_Comment_Adapter;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Recommend_Comment_Item;

import java.util.ArrayList;
import java.util.List;

public class Food_Detail extends Fragment {

    private View rootView;
    private List<Recommend_Comment_Item> list = new ArrayList<Recommend_Comment_Item>();
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.recommend_content,container,false);

        init();

        listView = (ListView) rootView.findViewById(R.id.content_list);
        Recommend_Comment_Adapter recommend_comment_adapter = new Recommend_Comment_Adapter(getContext(),R.layout.recommend_comment_item,list);
        listView.setAdapter(recommend_comment_adapter);

        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
            }
        });

        return rootView;
    }

    private void init() {
        Recommend_Comment_Item r1 = new Recommend_Comment_Item(3f,"这是一个评论","美食1","美食2","美食3");
        Recommend_Comment_Item r2 = new Recommend_Comment_Item(5f,"这也是一个评论","美食1","美食2","美食3");
        list.add(r1);
        list.add(r2);
    }

}
