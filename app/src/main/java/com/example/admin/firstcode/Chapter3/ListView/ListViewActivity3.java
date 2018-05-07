package com.example.admin.firstcode.Chapter3.ListView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.admin.firstcode.Chapter3.FruitBean;
import com.example.admin.firstcode.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyue on 2018/5/7.
 */

public class ListViewActivity3  extends AppCompatActivity {

    private List<FruitBean> fruitBeanList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter3_listview_activity);

        initData();
        FruitViewHolderAdapter adapter = new FruitViewHolderAdapter(this, R.layout.chapter3_lv_item, fruitBeanList);
        ListView listView = (ListView) findViewById(R.id.lv_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FruitBean fruitBean =fruitBeanList.get(position);
                Toast.makeText(ListViewActivity3.this,fruitBean.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData() {
        for (int i = 0; i < 200; i++) {
            FruitBean apple = new FruitBean("apple", R.drawable.chapter3_selected);
            fruitBeanList.add(apple);
            FruitBean banana = new FruitBean("banana", R.drawable.chapter3_unselected);
            fruitBeanList.add(banana);
        }
    }
}

