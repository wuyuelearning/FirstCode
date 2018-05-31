package com.example.admin.firstcode.Chapter9;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.admin.firstcode.Chapter9.HttpConnect.HttpConnectActivity;
import com.example.admin.firstcode.Chapter9.HttpConnect.WebViewActivity;
import com.example.admin.firstcode.Chapter9.HttpConnectUtil.HttpUtilActivity;
import com.example.admin.firstcode.Chapter9.Parse.ParseJsonActivity;
import com.example.admin.firstcode.Chapter9.Parse.ParseXMLActivity;
import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/29.
 */

public class Chapter9Activity extends AppCompatActivity implements View.OnClickListener {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter9_menu_activity);
        textView1 = findViewById(R.id.chapter9_1);
        textView1.setOnClickListener(this);
        textView2 = findViewById(R.id.chapter9_2);
        textView2.setOnClickListener(this);
        textView3 = findViewById(R.id.chapter9_3);
        textView3.setOnClickListener(this);
        textView4 = findViewById(R.id.chapter9_4);
        textView4.setOnClickListener(this);
        textView5 = findViewById(R.id.chapter9_5);
        textView5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.chapter9_1:
                intent = new Intent(this, WebViewActivity.class);
                break;
            case R.id.chapter9_2:
                intent = new Intent(this, HttpConnectActivity.class);
                break;
            case R.id.chapter9_3:
                intent = new Intent(this, ParseXMLActivity.class);
                break;
            case R.id.chapter9_4:
                intent = new Intent(this, ParseJsonActivity.class);
                break;
            case R.id.chapter9_5:
                intent = new Intent(this, HttpUtilActivity.class);
                break;
            default:
                break;

        }
        startActivity(intent);
    }
}
