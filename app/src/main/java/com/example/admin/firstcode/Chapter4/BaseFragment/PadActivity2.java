package com.example.admin.firstcode.Chapter4.BaseFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/10.
 */

public class PadActivity2 extends AppCompatActivity implements View.OnClickListener {
    Button mBotton;
    boolean changeFragment = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter4_pad_activity2);

        mBotton = (Button) findViewById(R.id.btn_left_fragment);
        mBotton.setOnClickListener(this);
        replayFragment(new RightFragment());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left_fragment:
                if (changeFragment) {
                    replayFragment(new AnotherRightFragment());
                    changeFragment = !changeFragment;
                } else {
                    replayFragment(new RightFragment());
                    changeFragment = !changeFragment;
                }
                break;
            default:
                break;
        }
    }

    private void replayFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_right_fragment, fragment);
        //返回上一个Fragment，即使点击button new出多个相同的fragment，回退时，也是一个一个回退后再退出
        // 即只要new出fragmen 都会模拟进入栈内
        // 模拟返回栈，生命周期会不同 进入栈后，并不一定会立即销毁 ，所以再出栈时可能不需要从第一步开始加载fragment
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public  void dos(){}


}
