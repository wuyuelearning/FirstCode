package com.example.admin.firstcode.Chapter13;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wuyue on 2018/6/23.
 * 序列化 接受
 */

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Serializable 序列化
        Person person =(Person)getIntent().getSerializableExtra("person_data");

        // Parcelable 序列化
        Person2 person2 =(Person2)getIntent().getParcelableExtra("person2_data");
    }
}
