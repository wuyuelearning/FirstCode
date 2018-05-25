package com.example.admin.firstcode.Chapter8.Notification;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.firstcode.R;
import com.example.admin.firstcode.Utils.NotificationUtil;

/**
 * Created by wuyue on 2018/5/24.
 * 《第一行代码》第二版 中8.2 节 使用通知
 * 在Android 8.0  版本无法实现显示通知栏
 *
 * 参考
 * https://blog.csdn.net/z642385985/article/details/78583980?locationNum=9&fps=1
 * 写法 得到NotificationUtil
 */

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter8_notification_activity);

        Button btn_notification_send = (Button) findViewById(R.id.btn_notification_send);
        btn_notification_send.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_notification_send: {
                Toast.makeText(this, "Boot Complete", Toast.LENGTH_LONG).show();

                Intent i =new Intent(this,NoticationOtherActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,0);
                NotificationUtil notificationUtil  =new NotificationUtil(this);
                notificationUtil.sendNotification("Title","this is a notice qwerqwerqwerqwerqwerqwerqweradsfasdfasdfqwerwdfasd",pendingIntent);
                break;
            }
        }
    }
}
