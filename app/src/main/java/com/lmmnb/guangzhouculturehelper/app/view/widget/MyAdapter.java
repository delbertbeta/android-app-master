package com.lmmnb.guangzhouculturehelper.app.view.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lmmnb.guangzhouculturehelper.R;

import java.util.List;

public class MyAdapter extends ArrayAdapter {

    private final int id;

    public MyAdapter(Context context, int ID, List<MyOption> object)
    {
        super(context,ID,object);
        id=ID;
    }

    public View getView(int position, View view, ViewGroup viewGroup)
    {

        MyOption myOption = (MyOption) getItem(position);
        View view1 = LayoutInflater.from(getContext()).inflate(id,null);
        ImageView i1 = (ImageView) view1.findViewById(R.id.i1);
        TextView t1 = (TextView) view1.findViewById(R.id.t1);
        i1.setImageResource(myOption.getImg());
        t1.setText(myOption.getOp());
        return view1;

    }

}
