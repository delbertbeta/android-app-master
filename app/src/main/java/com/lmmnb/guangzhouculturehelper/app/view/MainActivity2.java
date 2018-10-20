package com.lmmnb.guangzhouculturehelper.app.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Comment_Item;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Comment_List_Adapter;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Food_Item;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Label_Item;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Label_List_Adapter;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Recommend_Comment_Adapter;
import com.lmmnb.guangzhouculturehelper.app.view.widget.Recommend_Comment_Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private List<Food_Item> list = new ArrayList<Food_Item>();

    public static List<Label_Item> list2 = new ArrayList<Label_Item>();

    public static List<Comment_Item> list3 = new ArrayList<Comment_Item>();

    public static List<Recommend_Comment_Item> list4 = new ArrayList<Recommend_Comment_Item>();

    public static ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend_content);

        init();

        Recommend_Comment_Adapter recommend_comment_adapter = new Recommend_Comment_Adapter(MainActivity2.this,R.layout.recommend_comment_item,list4);
        listView = (ListView) findViewById(R.id.content_list);
        listView.setAdapter(recommend_comment_adapter);

        /*  3
        Comment_List_Adapter comment_list_adapter = new Comment_List_Adapter(MainActivity2.this,R.layout.comment_item,list3);
        listView = (ListView) findViewById(R.id.mytest);
        listView.setAdapter(comment_list_adapter);
        */

/*      2
        Label_List_Adapter label_list_adapter = new Label_List_Adapter(MainActivity2.this,R.layout.label_item,list2);
        listView = (ListView) findViewById(R.id.mytest);
        listView.setDividerHeight(0);
        listView.setAdapter(label_list_adapter);
*/

/*      1
        Food_List_Adapter food_list_adapter = new Food_List_Adapter(MainActivity2.this,R.layout.want_item,list);
        ListView listView  = (ListView) findViewById(R.id.mytest);
        listView.setAdapter(food_list_adapter);
*/
    }

    private void init() {

        /* 1
        Food_Item food_item = new Food_Item("虾饺",R.drawable.cover,1f,"我想转专业",true,"没事","美食");
        list.add(food_item);
        Food_Item food_item1 = new Food_Item("凤爪",R.drawable.cover,2f,"我要崩溃了",false,"quit","test");
        list.add(food_item1);
*/

        /*  2
        Label_Item label_item = new Label_Item("我喜欢");
        Label_Item label_item1 = new Label_Item("我讨厌");
        list2.add(label_item);
        list2.add(label_item1);
         */

        /* 3
        Comment_Item comment_item = new Comment_Item("虾饺",2f,"haochi");
        Comment_Item comment_item1 = new Comment_Item("凤爪",3f,"不好出");
        list3.add(comment_item);
        list3.add(comment_item1);
        */

        Recommend_Comment_Item r1 = new Recommend_Comment_Item(3f,"这大概就是评价了吧","沙雕","安卓","毁我青春");
        Recommend_Comment_Item r2 = new Recommend_Comment_Item(4f,"这大概就是评价2了吧","关爱","孩子","别打代码");
        list4.add(r1);
        list4.add(r2);
    }

}
