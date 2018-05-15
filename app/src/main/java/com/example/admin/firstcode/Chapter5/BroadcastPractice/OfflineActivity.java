package com.example.admin.firstcode.Chapter5.BroadcastPractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/15.
 *
 * 强制下线功能 点击按钮 广播
 */

public class OfflineActivity  extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter5_offline_activity);

        Button btn_offline= (Button)findViewById(R.id.btn_offline);
        btn_offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent("com.example.admin.firstcode.Chapter5.BroadcastPractice.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
