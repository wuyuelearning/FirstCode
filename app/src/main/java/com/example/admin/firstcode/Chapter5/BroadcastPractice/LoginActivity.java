package com.example.admin.firstcode.Chapter5.BroadcastPractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/14.
 */

public class LoginActivity extends BaseActivity {

    private EditText et_account;
    private EditText et_password;
    private Button btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter5_login_activity);
        et_account = (EditText)findViewById(R.id.et_account);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = et_account.getText().toString();
                String password = et_password.getText().toString();

                if(account.equals("admin") && password.equals("111111")){
                    Intent intent =new Intent(LoginActivity.this,OfflineActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this,"account or password is invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
