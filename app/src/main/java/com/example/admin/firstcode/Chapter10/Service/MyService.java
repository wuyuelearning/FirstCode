package com.example.admin.firstcode.Chapter10.Service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.admin.firstcode.Chapter10.Service.ServiceActivity;
import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/6/8.
 */

public class MyService extends Service {

    private DownloadBinder mDownloadBinder =new DownloadBinder();
    public MyService() {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mDownloadBinder;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "onCreate executed");
        Intent intent= new Intent(this,ServiceActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent , 0);
        Notification notification =new NotificationCompat.Builder(this)
                .setContentTitle("title")
                .setContentText("text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1,notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService", "onDestory executed");
    }

    class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d("MyService", "startDownload executed");
        }

        public int getProgress() {
            Log.d("MyService", "getProgress executed");
            return 0;
        }

    }
}
