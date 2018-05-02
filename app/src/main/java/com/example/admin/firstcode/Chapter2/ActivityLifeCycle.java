package com.example.admin.firstcode.Chapter2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.admin.firstcode.R;

/**
 * Created by admin on 2018/5/2.
 */

public class ActivityLifeCycle extends AppCompatActivity implements View.OnClickListener {

    TextView tv_start_normal_activity;
    TextView tv_start_dialog_activity;

    private static final String Activity_Life_Cycle_TAG = "activity_life_cycle";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter2_activity_life_cycle);
        initView();
    }

    private void initView() {
        tv_start_normal_activity = (TextView) findViewById(R.id.tv_start_normal_activity);
        tv_start_normal_activity.setOnClickListener(this);
        tv_start_dialog_activity = (TextView) findViewById(R.id.tv_start_dialog_activity);
        tv_start_dialog_activity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tv_start_normal_activity:
                intent = new Intent(this, NormalAcitivity.class);
                break;
            case R.id.tv_start_dialog_activity:
                intent = new Intent(this, DialogActivity.class);
                break;
        }
        startActivity(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Activity_Life_Cycle_TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        Log.d(Activity_Life_Cycle_TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Activity_Life_Cycle_TAG, "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Activity_Life_Cycle_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Activity_Life_Cycle_TAG, "onDestroy");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Activity_Life_Cycle_TAG, "onResume");

    }


}
