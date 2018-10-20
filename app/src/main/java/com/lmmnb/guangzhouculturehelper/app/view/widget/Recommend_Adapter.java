package com.lmmnb.guangzhouculturehelper.app.view.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.idlestar.ratingstar.RatingStarView;
import com.jaren.lib.view.LikeView;
import com.lmmnb.guangzhouculturehelper.R;

import java.util.List;

public class Recommend_Adapter extends ArrayAdapter {

    private final int id;

    public Recommend_Adapter(Context context, int ID, List<Recommend_item> object)
    {
        super(context,ID,object);
        id=ID;
    }

    public View getView(int position, View view, ViewGroup viewGroup)
    {

        Recommend_item food_item = (Recommend_item) getItem(position);
        View view1 = LayoutInflater.from(getContext()).inflate(id,null);

        ImageView i1 = (ImageView) view1.findViewById(R.id.recommend_pic);
        TextView n = (TextView) view1.findViewById(R.id.recommend_t1);
        TextView in = (TextView) view1.findViewById(R.id.recommend_introduce);
        RatingStarView ratingStarView = (RatingStarView)view1.findViewById(R.id.recommend_star);

        i1.setImageResource(food_item.getImg());
        n.setText(food_item.getName());
        in.setText(food_item.getIntro());
        ratingStarView.setRating(food_item.getRatingStarView());

        TextView x = (TextView)view1.findViewById(R.id.recommend_l1);
        x.setText(food_item.getL1());

        TextView y =  (TextView)view1.findViewById(R.id.recommend_l2);
        y.setText(food_item.getL2());


        return view1;

    }
}
