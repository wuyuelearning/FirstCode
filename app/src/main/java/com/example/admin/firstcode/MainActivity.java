package com.example.admin.firstcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.admin.firstcode.Chapter2.ActivityLifeCycle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        textView =(TextView)findViewById(R.id.text1);
        textView.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent  =null;
        switch (v.getId()){
            case R.id.text1 :
                intent =new Intent(this,ActivityLifeCycle.class);
                break;
        }
        startActivity(intent);

    }
}
