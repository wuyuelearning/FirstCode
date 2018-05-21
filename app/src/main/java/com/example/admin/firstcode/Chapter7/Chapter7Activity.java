package com.example.admin.firstcode.Chapter7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/21.
 * <p>
 * ContentProvider
 */

public class Chapter7Activity extends AppCompatActivity implements View.OnClickListener {

    TextView text1;
    TextView text2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter7_menu_activity);

        text1 = (TextView) findViewById(R.id.tv_runtime1);
        text1.setOnClickListener(this);
        text2 = (TextView) findViewById(R.id.tv_read_contact);
        text2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tv_runtime1:
                intent = new Intent(this, RuntimePermissionActivity.class);
                break;
            case R.id.tv_read_contact:
                intent = new Intent(this, ReadContactActivity.class);
                break;

            default:
                break;
        }
        startActivity(intent);
    }
}
