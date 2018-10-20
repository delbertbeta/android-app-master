package com.lmmnb.guangzhouculturehelper.app.view.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.idlestar.ratingstar.RatingStarView;
import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.MainActivity2;

import java.util.List;

public class Comment_List_Adapter extends ArrayAdapter {

    private final int id;

    public Comment_List_Adapter(Context context, int ID, List<Comment_Item> object) {
        super(context, ID, object);
        id = ID;
    }

    public View getView(final int position, View view, ViewGroup viewGroup) {

        Comment_Item comment_item = (Comment_Item) getItem(position);

        View view1 = LayoutInflater.from(getContext()).inflate(id,null);

        TextView textView = (TextView) view1.findViewById(R.id.my_content);
        textView.setText(comment_item.getFood_name());

        TextView textView1 = (TextView) view1.findViewById(R.id.comment);
        textView1.setText(comment_item.getComment());

        RatingStarView ratingStarView = (RatingStarView) view1.findViewById(R.id.food_rating);
        ratingStarView.setRating(comment_item.getRating());


        Button button = (Button) view1.findViewById(R.id.delete_comment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity2.list3.remove(position);
                Comment_List_Adapter label_list_adapter = new Comment_List_Adapter(getContext(),R.layout.comment_item,MainActivity2.list3);
                MainActivity2.listView.setAdapter(label_list_adapter);

            }
        });

        return  view1;
    }
}
