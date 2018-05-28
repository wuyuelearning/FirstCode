package com.example.admin.firstcode.Chapter8;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


import com.example.admin.firstcode.Chapter8.CameraAlbum.CameraAlbumActivity;
import com.example.admin.firstcode.Chapter8.MediaPlayer.PlayAudioActivity;
import com.example.admin.firstcode.Chapter8.MediaPlayer.PlayVideoActivity;
import com.example.admin.firstcode.Chapter8.Notification.NotificationActivity;
import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/24.
 */

public class Chapter8Activity extends AppCompatActivity implements View.OnClickListener{
    TextView textView1 ;
    TextView textView2 ;
    TextView textView3 ;
    TextView textView4 ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter8_menu_activity);

        textView1 = (TextView)findViewById(R.id.tv_chapter8_1);
        textView1.setOnClickListener(this);
        textView2 = (TextView)findViewById(R.id.tv_chapter8_2);
        textView2.setOnClickListener(this);
        textView3 = (TextView)findViewById(R.id.tv_chapter8_3);
        textView3.setOnClickListener(this);
        textView4 = (TextView)findViewById(R.id.tv_chapter8_4);
        textView4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.tv_chapter8_1 :
                intent =new Intent(this,NotificationActivity.class);
                break;
            case R.id.tv_chapter8_2 :
                intent =new Intent(this,CameraAlbumActivity.class);
                break;
            case R.id.tv_chapter8_3 :
                intent =new Intent(this,PlayAudioActivity.class);
                break;
            case R.id.tv_chapter8_4 :
                intent =new Intent(this,PlayVideoActivity.class);
                break;

                default:
                    break;
        }
        startActivity(intent);
    }
}
