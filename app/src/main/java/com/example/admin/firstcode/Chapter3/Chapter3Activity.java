package com.example.admin.firstcode.Chapter3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.admin.firstcode.Chapter3.ListView.ListViewActivity1;
import com.example.admin.firstcode.Chapter3.ListView.ListViewActivity2;
import com.example.admin.firstcode.Chapter3.ListView.ListViewActivity3;
import com.example.admin.firstcode.Chapter3.RecyclerView.RecyclerViewAcrivity;
import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/7.
 */

public class Chapter3Activity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_listView1;
    private TextView tv_listView2;
    private TextView tv_listView3;
    private TextView tv_recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter3_menu_activity);
        initView();
    }

    private void initView() {
        tv_listView1 = (TextView) findViewById(R.id.tv_listView1);
        tv_listView1.setOnClickListener(this);
        tv_listView2 = (TextView) findViewById(R.id.tv_listView2);
        tv_listView2.setOnClickListener(this);
        tv_listView3 = (TextView) findViewById(R.id.tv_listView3);
        tv_listView3.setOnClickListener(this);
        tv_recyclerView=(TextView) findViewById(R.id.tv_recyclerView);
        tv_recyclerView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tv_listView1:
                intent = new Intent(this, ListViewActivity1.class);
                break;
            case R.id.tv_listView2:
                intent = new Intent(this, ListViewActivity2.class);
                break;
            case R.id.tv_listView3:
                intent = new Intent(this, ListViewActivity3.class);
                break;
            case R.id.tv_recyclerView:
                intent = new Intent(this, RecyclerViewAcrivity.class);
                break;

        }
        startActivity(intent);
    }
}
