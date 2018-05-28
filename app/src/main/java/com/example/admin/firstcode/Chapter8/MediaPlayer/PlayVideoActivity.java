package com.example.admin.firstcode.Chapter8.MediaPlayer;

import android.Manifest;
import android.content.pm.PackageManager;
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
import android.widget.VideoView;

import com.example.admin.firstcode.R;

import java.io.File;

/**
 * Created by wuyue on 2018/5/28.
 * <p>
 * 视频播放器
 */

public class PlayVideoActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView videoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter8_video_player_activity);
        initView();
    }

    private void initView() {
        Button btn_play_video = (Button) findViewById(R.id.btn_play_video);
        Button btn_pause_video = (Button) findViewById(R.id.btn_pause_video);
        Button btn_replay_video = (Button) findViewById(R.id.btn_replay_video);
        videoView = (VideoView) findViewById(R.id.vv_video_player);

        btn_play_video.setOnClickListener(this);
        btn_pause_video.setOnClickListener(this);
        btn_replay_video.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(PlayVideoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PlayVideoActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            initVidePath();  //  初始化VideoView
        }
    }

    private void initVidePath() {
        // music.MP4文件要放在手机的根目录下
        File file = new File(Environment.getExternalStorageDirectory(), "movie.mp4");
        //    Environment.getExternalStorageDirectory().toString(): /storage/emulated/0
        Log.d("pathDir", "" + Environment.getExternalStorageDirectory().toString());
        videoView.setVideoPath(file.getPath());   //  指定视频文件路径
        //    file.getPath().toString():    /storage/emulated/0/movie.mp4
        Log.d("pathDir", "" + file.getPath().toString());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initVidePath();
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
            case R.id.btn_play_video:
                if (!videoView.isPlaying()) {
                    videoView.start();  //  开始播放
                }
                break;
            case R.id.btn_pause_video:
                if (videoView.isPlaying()) {
                    videoView.pause();  //  暂停播放
                }
                break;
            case R.id.btn_replay_video:
                if (videoView.isPlaying()) {
                    videoView.resume();  //  重新播放
                    videoView.start();  //  书上没有 videoView.start();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.suspend();
        }
    }
}
