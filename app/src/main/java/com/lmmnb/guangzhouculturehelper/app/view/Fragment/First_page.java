package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    public static TextView tv4translate; //翻译文本
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
        tv4translate = (TextView) rootView.findViewById(R.id.tv4translate);

        recordButton = (RecordButton)rootView.findViewById(R.id.record);
        exchangbtn = (ExchangeButton)rootView.findViewById(R.id.ExchangeButton);


        clearbtn=(ImageButton)rootView.findViewById(R.id.clearBtn);
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.et2.setText("");
            }
        });

        et1.et2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_SEND
                        || i == EditorInfo.IME_ACTION_DONE
                        || (keyEvent != null
                        && KeyEvent.KEYCODE_ENTER == keyEvent.getKeyCode()
                        && KeyEvent.ACTION_DOWN == keyEvent.getAction()))
                {
                    String translatedStr = "普通话->粤语，已经翻译好的文本";
                    // 在这里添加动态改变控件位置的代码
//                    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams)et1.getLayoutParams();
//                    layoutParams.setMargins(0,120,0,0);
                    tv4translate.setText(translatedStr);
                    tv4translate.bringToFront();
                }
                return false;
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