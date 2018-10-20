package com.lmmnb.guangzhouculturehelper.app.view.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.Fragment.Content2;
import com.lmmnb.guangzhouculturehelper.app.view.Fragment.My;
import com.lmmnb.guangzhouculturehelper.app.view.MainActivity2;

import java.util.List;

public class Label_List_Adapter extends ArrayAdapter {

    private final int id;

    public Label_List_Adapter(Context context, int ID, List<Label_Item> object) {
        super(context, ID, object);
        id = ID;
    }

    public View getView(final int position, View view, ViewGroup viewGroup) {

        Label_Item label_item = (Label_Item) getItem(position);

        View view1 = LayoutInflater.from(getContext()).inflate(id,null);

        TextView textView = (TextView) view1.findViewById(R.id.label);
        textView.setText(label_item.getLabel_name());

        Button button = (Button) view1.findViewById(R.id.delete_list_item);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
                My.list3.remove(position);
                Label_List_Adapter label_list_adapter = new Label_List_Adapter(getContext(),R.layout.label_item,My.list3);
                Content2.listView.setAdapter(label_list_adapter);
            }
        });

        return  view1;
    }
}