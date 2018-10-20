package com.lmmnb.guangzhouculturehelper.app.view.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.idlestar.ratingstar.RatingStarView;
import com.lmmnb.guangzhouculturehelper.R;

import java.util.List;

public class Recommend_Comment_Adapter extends ArrayAdapter {

    private final int id;

    public Recommend_Comment_Adapter(Context context, int ID, List<Recommend_Comment_Item> object) {
        super(context, ID, object);
        id = ID;
    }

    public View getView(final int position, View view, ViewGroup viewGroup)
    {
        View view1 = LayoutInflater.from(getContext()).inflate(id,null);

        Recommend_Comment_Item recommend_comment_item = (Recommend_Comment_Item) getItem(position);

        RatingStarView ratingStarView = (RatingStarView) view1.findViewById(R.id.recommend_rating);
        ratingStarView.setRating(recommend_comment_item.getRating());

        TextView textView = (TextView) view1.findViewById(R.id.recommend_comment);
        textView.setText(recommend_comment_item.getComment());

        TextView t1 = (TextView) view1.findViewById(R.id.recommend_label1);
        t1.setText(recommend_comment_item.getLabel1());

        TextView t2 = (TextView) view1.findViewById(R.id.recommend_label2);
        t2.setText(recommend_comment_item.getLabel2());

        TextView t3 = (TextView) view1.findViewById(R.id.recommend_label3);
        t3.setText(recommend_comment_item.getLabel3());

        return view1;
    }
}
