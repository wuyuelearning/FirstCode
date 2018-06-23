package com.example.admin.firstcode.Utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by wuyue on 2018/6/23.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
