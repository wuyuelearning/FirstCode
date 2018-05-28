package com.example.admin.firstcode.Chapter8.MediaPlayer;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.firstcode.R;

import java.io.File;
import java.io.IOException;

/**
 * Created by wuyue on 2018/5/28.
 *
 * 音频播放器
 */

public class PlayAudioActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter8_play_audio_activity);
        initView();
    }

    private void initView() {

        Button btn_play_audio = (Button) findViewById(R.id.btn_play_audio);
        Button btn_pause_audio = (Button) findViewById(R.id.btn_pause_audio);
        Button btn_stop_audio = (Button) findViewById(R.id.btn_stop_audio);

        btn_play_audio.setOnClickListener(this);
        btn_pause_audio.setOnClickListener(this);
        btn_stop_audio.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(PlayAudioActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PlayAudioActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            initMediaPlayer();  //  初始化MediaPlayer
        }

    }

    private void initMediaPlayer() {
        //  music.mp3 文件要放在手机的根目录下
        File file = new File(Environment.getExternalStorageDirectory(), "music.mp3");
        // Environment.getExternalStorageDirectory():  /storage/emulated/0
        Log.d("pathDir", "" + Environment.getExternalStorageDirectory().toString());
        try {
            mediaPlayer.setDataSource(file.getPath());    //  指定音频文件的路径
            mediaPlayer.prepare();                //  让 MediaPlayer 进入到准备状态
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initMediaPlayer();
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play_audio:
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();   // 开始播放
                }
                break;
            case R.id.btn_pause_audio:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();   // 停止播放
                }
                break;
            case R.id.btn_stop_audio:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.reset();   // 停止播放
                    initMediaPlayer();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
