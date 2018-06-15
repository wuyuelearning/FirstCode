package com.example.admin.firstcode.Chapter10.Asynchronous;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/6/2.
 *
 * 在子线程中更新UI
 */

public class RunnableTestActivity  extends AppCompatActivity implements View.OnClickListener{

    private static final int UPDATE_TEXT=1;
    TextView tv_change_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter10_runnable_test_activity);

        Button btn_change_text = (Button) findViewById(R.id.btn_change_text);
        btn_change_text.setOnClickListener(this);

        tv_change_text = (TextView) findViewById(R.id.tv_change_text);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_change_text:
            {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message =new Message();
                        message.what =UPDATE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();

                break;
            }
            default:
                break;
        }
    }

    private Handler handler =new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:{
                    //  在这里进行UI操作
                    tv_change_text.setText("Nice to meet you");
                    break;
                }
                default:
                    break;
            }
        }
    };
}
