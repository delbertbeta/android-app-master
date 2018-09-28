package com.lmmnb.guangzhouculturehelper.app.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lmmnb.guangzhouculturehelper.R;

import java.util.zip.CheckedOutputStream;


public class MyImgBtn extends RelativeLayout {

    private ImageView back = null;
    private ImageView search = null;
    private TextView tx = null;
    private Context mycontext;

    public MyImgBtn(Context context, AttributeSet attrs)
    {
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.image_button,this,true);
        mycontext = context;
        back = (ImageView)findViewById(R.id.back);
        search = (ImageView) findViewById(R.id.search);
    }

    public void setOnTouch(OnTouchListener listen)
    {
        this.setOnTouchListener(listen);
    }

}
