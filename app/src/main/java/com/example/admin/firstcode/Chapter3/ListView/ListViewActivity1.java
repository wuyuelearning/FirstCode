package com.example.admin.firstcode.Chapter3.ListView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/7.
 */

public class ListViewActivity1 extends AppCompatActivity {
    private String[] data = {"apple", "origin", "banana", "apple", "origin", "banana", "apple", "origin", "banana", "apple", "origin", "banana"
            , "apple", "origin", "banana", "apple", "origin", "banana", "apple", "origin", "banana"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter3_listview_activity);
        ArrayAdapter <String> adapter = new ArrayAdapter<>(ListViewActivity1.this,android.R.layout.simple_list_item_1,data);
        ListView listView =(ListView) findViewById(R.id.lv_listview);
        listView.setAdapter(adapter);
    }
}
