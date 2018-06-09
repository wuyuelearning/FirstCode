package com.example.admin.firstcode.Chapter10.Service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;

import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/6/8.
 */

public class ServiceActivity  extends AppCompatActivity implements OnClickListener{
    private MyService.DownloadBinder mDownloadBinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter10_service_activity);

        Button btn_start_service =findViewById(R.id.btn_start_service);
        Button btn_stop_service =findViewById(R.id.btn_stop_service);
        Button btn_bind_service =findViewById(R.id.btn_bind_service);
        Button btn_unbind_service =findViewById(R.id.btn_unbind_service);
        Button btn_start_intent_service =findViewById(R.id.btn_start_intent_service);

        btn_start_service.setOnClickListener(this);
        btn_stop_service.setOnClickListener(this);
        btn_bind_service.setOnClickListener(this);
        btn_unbind_service.setOnClickListener(this);
        btn_start_intent_service.setOnClickListener(this);
    }

    private ServiceConnection connection =new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDownloadBinder =(MyService.DownloadBinder)service;
            mDownloadBinder.startDownload();
            mDownloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_start_service :{
                Intent startIntent = new Intent(this,MyService.class);
                startService(startIntent);
                break;
            }
            case R.id.btn_stop_service :{
                Intent stopIntent = new Intent(this,MyService.class);
                stopService(stopIntent);
                break;
            }
            case R.id.btn_bind_service: {
                Intent bindService =new Intent(this,MyService.class);
                bindService(bindService,connection,BIND_AUTO_CREATE);   //  绑定服务
                break;
            }
            case R.id.btn_unbind_service :{
                unbindService(connection);  //  解绑服务
                break;
            }
            case R.id.btn_start_intent_service:{
                //  打印主线程
                Log.d("ServiceActivity","Thread id is "+Thread.currentThread().getId());
                Intent intentService =new Intent(this,MyIntentService.class);
                startService(intentService);
                break;
            }
            default:
                break;
        }
    }
}
