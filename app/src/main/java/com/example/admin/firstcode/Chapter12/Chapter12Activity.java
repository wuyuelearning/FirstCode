package com.example.admin.firstcode.Chapter12;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/6/17.
 */

public class Chapter12Activity extends AppCompatActivity implements View.OnClickListener{
    TextView text1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter12_menu_activity);
        text1 = (TextView) findViewById(R.id.tv_chapter12_1);
        text1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tv_chapter12_1:
                intent = new Intent(this, MaterialDesignActivity.class);
                break;

            default:
                break;
        }
        startActivity(intent);
    }
}
