package com.example.admin.firstcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.admin.firstcode.Chapter2.Chapter2Activity;
import com.example.admin.firstcode.Chapter3.Chapter3Activity;
import com.example.admin.firstcode.Utils.ActivityCollector;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity",getClass().getSimpleName());
        ActivityCollector.addActivity(this);
        initView();
    }

    private void initView(){
        textView1 =(TextView)findViewById(R.id.text1);
        textView1.setOnClickListener(this);
        textView2 =(TextView)findViewById(R.id.text2);
        textView2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent  =null;
        switch (v.getId()){
            case R.id.text1 :
                intent =new Intent(this,Chapter2Activity.class);
                break;
            case R.id.text2 :
                intent =new Intent(this,Chapter3Activity.class);
                break;
        }
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoteActivity(this);
    }
}
