package com.example.admin.firstcode.Chapter5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.admin.firstcode.Chapter5.BaseBroadcast.DynamicRegistrationActivity;
import com.example.admin.firstcode.Chapter5.BroadcastPractice.LoginActivity;
import com.example.admin.firstcode.Chapter5.DefinedBroadcast.MyBroadcastReceiverActivity;
import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/11.
 */

public class Chapter5Activity extends AppCompatActivity implements View.OnClickListener {
    private TextView text1;
    private TextView text2;
    private TextView text3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter5_menu_activity);
        text1 = (TextView) findViewById(R.id.tv_broadcast1);
        text1.setOnClickListener(this);
        text2 = (TextView) findViewById(R.id.tv_broadcast2);
        text2.setOnClickListener(this);
        text3 = (TextView) findViewById(R.id.tv_broadcast3);
        text3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tv_broadcast1:
                intent =new Intent(this,DynamicRegistrationActivity.class);
                break;
            case R.id.tv_broadcast2:
                intent =new Intent(this,MyBroadcastReceiverActivity.class);
                break;
            case R.id.tv_broadcast3:
                intent =new Intent(this,LoginActivity.class);
                break;
            default:
                break;
        }

        startActivity(intent);
    }
}
