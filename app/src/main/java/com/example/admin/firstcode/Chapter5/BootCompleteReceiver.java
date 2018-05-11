package com.example.admin.firstcode.Chapter5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by wuyue on 2018/5/11.
 *
 * 静态注册Broadcast
 * 需要在AndroidManifest.xml中添加注册信息
 */

public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Boot Complete",Toast.LENGTH_LONG).show();
    }
}
