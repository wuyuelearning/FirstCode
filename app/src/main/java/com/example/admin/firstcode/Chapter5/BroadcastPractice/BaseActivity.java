package com.example.admin.firstcode.Chapter5.BroadcastPractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.firstcode.Utils.ActivityCollector;

/**
 * Created by wuyue on 2018/5/14.
 * 统一注册广播监听器  继承了BaseActivity后即可注册广播
 * 不需在每一个需要广播的Activity中注册广播
 */

public class BaseActivity extends AppCompatActivity {

    ForceOfflineReceiver forceOfflineReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }


    //  在onResume和onPause中而不是在onCreate和onDestory中注册和注销  为了仅让处于栈顶的Activity才强制下线
    //   当一个Activity失去了栈顶位置就会自动取消广播接收器的注册
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.admin.firstcode.Chapter5.BroadcastPractice.FORCE_OFFLINE");
        forceOfflineReceiver = new ForceOfflineReceiver();
        registerReceiver(forceOfflineReceiver, intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (forceOfflineReceiver != null) {
            unregisterReceiver(forceOfflineReceiver);
            forceOfflineReceiver = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoteActivity(this);
    }

    class ForceOfflineReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(final Context context, final Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Warning");
            builder.setMessage("You are forced to be offline. Please try to login again");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();// 销毁所有活动
                    Intent i = new Intent(context, LoginActivity.class);  // 重启LoginActivity
                    context.startActivity(i);
                }
            });
            builder.show();
        }
    }
}
