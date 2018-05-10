package com.example.admin.firstcode.Chapter4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/10.
 */

public class Chapter4Activity extends AppCompatActivity implements View.OnClickListener {
    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter4_menu_activity);
        textView1 = (TextView) findViewById(R.id.tv_fragment1);
        textView1.setOnClickListener(this);
        textView2 = (TextView) findViewById(R.id.tv_fragment2);
        textView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tv_fragment1:
                intent = new Intent(this, PadActivity.class);
                break;
            case R.id.tv_fragment2:
                intent = new Intent(this, PadActivity2.class);
                break;
            default:
                break;

        }
        startActivity(intent);

    }
}
