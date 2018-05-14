package com.example.admin.firstcode.Chapter5.DefinedBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/14.
 * <p>
 * 自定义广播+本地广播
 */

public class MyBroadcastReceiverActivity extends AppCompatActivity {

    private IntentFilter intentFilter;

    private LocalReceiver localReceiver;

    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter5_my_broadcast_receiver_activity);

        // 标准广播
        Button button = (Button) findViewById(R.id.btn_standard_broadcast_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.admin.firstcode.Chapter5.DefinedBroadcast.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });


        // 有序广播
        Button button2 = (Button) findViewById(R.id.btn_orderly_broadcast_send);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.admin.firstcode.Chapter5.DefinedBroadcast.MY_BROADCAST");
                sendOrderedBroadcast(intent, null);
            }
        });

        localBroadcastManager =LocalBroadcastManager.getInstance(this);// 获取实例

        // 本地广播
        Button button3 = (Button) findViewById(R.id.btn_local_broadcast_send);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.admin.firstcode.Chapter5.DefinedBroadcast.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent); // 发送本地广播
            }
        });

        intentFilter =new IntentFilter();
        intentFilter.addAction("com.example.admin.firstcode.Chapter5.DefinedBroadcast.LOCAL_BROADCAST");
        localReceiver =new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter); //  注册本地广播监听器
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localReceiver);
    }

    class LocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"received in local BroadcastReceiver ",Toast.LENGTH_SHORT).show();
        }
    }
}



