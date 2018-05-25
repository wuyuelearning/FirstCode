package com.example.admin.firstcode.Utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

import com.example.admin.firstcode.R;

import java.io.File;

/**
 * Created by wuyue on 2018/5/25.
 * 在Android 8.0  增加通知的安全等级
 * 之前的写法无法显示通知栏
 */

public class NotificationUtil extends ContextWrapper{
    private NotificationManager manager;
    private String channel_id = "channel_1";
    private String channel_name = "channel_name_1";

    public NotificationUtil(Context context) {
        super(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(){
        NotificationChannel channel = new NotificationChannel(channel_id,channel_name,NotificationManager.IMPORTANCE_HIGH);
        getManager().createNotificationChannel(channel);
    }
    private NotificationManager getManager(){
        if(manager == null){
            manager =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        }
        return manager;
    }

    // API  26及以上版本
    @RequiresApi(api = Build.VERSION_CODES.O)
    private Notification.Builder getChannelNotification(String title , String content,PendingIntent pi){
        return new Notification.Builder(getApplicationContext(),channel_id)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
//                .setVibrate(new long[]{0,1000,0,1000})
//                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
//                .setLights(Color.GREEN,1000,1000)
                .setDefaults(Notification.DEFAULT_ALL)
                .setStyle(new Notification.BigTextStyle().bigText(content))
                .setStyle(new Notification.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.help_icon)))
                .setPriority(Notification.PRIORITY_MIN);



    }


    /**
     * API 26 以下的版本
     *
     * @param title
     * @param content
     * @return
     */
    private NotificationCompat.Builder getNotifictionUnder26(String title , String content, PendingIntent pi){
        return new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
//                .setVibrate(new long[]{0,1000,0,1000})
//                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
//                .setLights(Color.GREEN,1000,1000)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(content))
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.help_icon)))
                .setPriority(NotificationCompat.PRIORITY_MIN);


    }


    public void sendNotification(String title ,String content,PendingIntent pi){
        if(Build.VERSION.SDK_INT>=26){
            createNotificationChannel();
            Notification notification =getChannelNotification(title,content,pi).build();
            getManager().notify(1,notification);
        } else {
            Notification notification = getNotifictionUnder26(title,content,pi).build();
            getManager().notify(1,notification);
        }
    }
}
