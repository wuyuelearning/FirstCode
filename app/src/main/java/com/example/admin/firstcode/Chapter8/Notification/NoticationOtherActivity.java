package com.example.admin.firstcode.Chapter8.Notification;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/25.
 */

public class NoticationOtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter8_notification_other_activity);
        NotificationManager manager =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        // 关闭通知栏  1表示关闭的是哪个通知
        // 与NotificationActivity.java中的  manager.notify(1, notification) 对应
        manager.cancel(1);

    }
}
