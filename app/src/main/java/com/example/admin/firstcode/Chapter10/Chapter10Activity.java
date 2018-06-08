package com.example.admin.firstcode.Chapter10;

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
 * Created by wuyue on 2018/6/2.
 */

public class Chapter10Activity extends AppCompatActivity implements View.OnClickListener{

    TextView text1;
    TextView text2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter10_menu_activity);

        text1  = findViewById(R.id.chapter10_1);
        text1.setOnClickListener(this);
        text2  = findViewById(R.id.chapter10_2);
        text2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.chapter10_1:
                intent = new Intent(this, RunnableTestActivity.class);
                break;
            case R.id.chapter10_2:
                intent = new Intent(this, ServiceActivity.class);
                break;

            default:
                break;

        }
        startActivity(intent);

    }
}
