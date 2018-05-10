package com.example.admin.firstcode.Chapter4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/10.
 * 静态加载fragment 例如在chapter4_pad_activity.xml
 * 中 通过
 * android:name="com.example.admin.firstcode.Chapter4.LeftFragment"
 * 静态加载fragment
 */

public class PadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter4_pad_activity);
    }
}
