package com.example.admin.firstcode.Chapter6;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/16.
 */

public class Chapter6Activity extends AppCompatActivity implements View.OnClickListener{

    TextView text1;
    TextView text2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter6_menu_activity);

        text1 =(TextView)findViewById(R.id.tv_save1);
        text1.setOnClickListener(this);

        text2 =(TextView)findViewById(R.id.tv_save2);
        text2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tv_save1:
                intent = new Intent(this, SaveToFileActivity.class);
                break;
            case R.id.tv_save2:
                intent = new Intent(this, SharedPreferencesActivity.class);
                break;

            default:
                break;
        }
        startActivity(intent);
    }
}
