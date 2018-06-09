package com.example.admin.firstcode.Chapter10.Service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by wuyue on 2018/6/9.
 */

public class MyIntentService extends IntentService{
    public MyIntentService(){
        super("MyIntentService");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // 打印当前线程
        Log.d("MyIntentService","Thread id is "+Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService","onDestroy executed");
    }
}
