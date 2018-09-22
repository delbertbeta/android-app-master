package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.MainActivity;
import com.lmmnb.guangzhouculturehelper.app.view.widget.ExchangeButton;
import com.lmmnb.guangzhouculturehelper.app.view.widget.MyEditText;
import com.lmmnb.guangzhouculturehelper.app.view.widget.MyOption;
import com.lmmnb.guangzhouculturehelper.app.view.widget.MyText;
import com.lmmnb.guangzhouculturehelper.app.view.widget.RecordButton;
import com.lmmnb.guangzhouculturehelper.app.view.widget.TextAdapter;

import java.util.ArrayList;
import java.util.List;


public class First_page extends Fragment {
    private ImageButton clearbtn;   //清除按钮
    private static ExchangeButton exchangbtn;
    public  static MyEditText et1;
    private RecordButton recordButton;  //录音按钮
    private ListView history;
    //用于储存ListView中的MyText对象
    private List<MyText> textList =new ArrayList<MyText>();

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.activity_main,container,false);
        //ListView部分
        textInput();
        TextAdapter adapter = new TextAdapter(rootView.getContext(),R.layout.text_item,textList);
        history = (ListView) rootView.findViewById(R.id.lv);
        history.setAdapter(adapter);

        et1=(MyEditText) rootView.findViewById(R.id.et1);

        recordButton = (RecordButton)rootView.findViewById(R.id.record);
        exchangbtn = (ExchangeButton)rootView.findViewById(R.id.ExchangeButton);


        clearbtn=(ImageButton)rootView.findViewById(R.id.clearBtn);
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.et2.setText("");
            }
        });
        return rootView;
    }

    private void textInput()
    {
        MyText a = new MyText("你好啊","雷猴啊");
        textList.add(a);
        MyText b = new MyText("不客气","唔该噻");
        textList.add(b);
        MyText c = new MyText("saonima","woaini");
        textList.add(c);
        MyText d = new MyText("woaini","saonima");
        textList.add(d);
    }

    public static boolean getText()
    {
        if(exchangbtn.getStart().equals("普通话"))
            return true;
        else
            return false;
    }

}