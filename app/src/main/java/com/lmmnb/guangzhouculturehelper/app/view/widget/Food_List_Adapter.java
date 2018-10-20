package com.lmmnb.guangzhouculturehelper.app.view.widget;

import android.content.Context;
import android.support.annotation.NonNull;
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

public class Food_List_Adapter extends ArrayAdapter {

    private final int id;

    public Food_List_Adapter(Context context, int ID, List<Food_Item> object)
    {
        super(context,ID,object);
        id=ID;
    }

    public View getView(int position, View view, ViewGroup viewGroup)
    {

        Food_Item food_item = (Food_Item) getItem(position);
        View view1 = LayoutInflater.from(getContext()).inflate(id,null);

        ImageView i1 = (ImageView) view1.findViewById(R.id.label_pic);
        TextView n = (TextView) view1.findViewById(R.id.textView3);
        TextView in = (TextView) view1.findViewById(R.id.introduce);
        RatingStarView ratingStarView = (RatingStarView)view1.findViewById(R.id.star);
        final LikeView likeView = (LikeView)view1.findViewById(R.id.likeview);

        i1.setImageResource(food_item.getImg());
        n.setText(food_item.getName());
        in.setText(food_item.getIntro());
        ratingStarView.setRating(food_item.getRatingStarView());

        likeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(likeView.isChecked())
                {
                    likeView.setCheckedWithoutAnimator(false);
                }
                else
                    likeView.toggle();
            }
        });

        if(food_item.getIf_like())
        {
            likeView.setChecked(true);
        }
        else
        {
            likeView.setChecked(false);
        }

        TextView x = (TextView)view1.findViewById(R.id.want_l1);
        x.setText(food_item.getL1());

        TextView y =  (TextView)view1.findViewById(R.id.want_l2);
        y.setText(food_item.getL2());



        return view1;

    }
}
