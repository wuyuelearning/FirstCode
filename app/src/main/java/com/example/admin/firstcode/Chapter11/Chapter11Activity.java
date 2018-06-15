package com.example.admin.firstcode.Chapter11;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/6/13.
 */

public class Chapter11Activity extends AppCompatActivity implements View.OnClickListener {

    TextView text1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter11_menu_activity);

        text1 = (TextView) findViewById(R.id.tv_chapter11_1);
        text1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tv_chapter11_1:
                intent = new Intent(this, LBSTestActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
