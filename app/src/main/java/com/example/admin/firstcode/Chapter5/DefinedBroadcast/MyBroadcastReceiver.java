package com.example.admin.firstcode.Chapter5.DefinedBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by wuyue on 2018/5/14.
 * 自定义标准广播的的接收器 BroadcastReceiver
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"received in MyBroadcastReceiver ",Toast.LENGTH_SHORT).show();
        abortBroadcast();//  有序广播中，判断是否拦截
    }
}
