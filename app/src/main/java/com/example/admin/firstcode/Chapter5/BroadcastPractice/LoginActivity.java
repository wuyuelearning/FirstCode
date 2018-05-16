package com.example.admin.firstcode.Chapter5.BroadcastPractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/14.
 *  强制下线功能
 *  登录之后在点击按钮后 强制下线，第五章broadcast内容
 *  记住密码，第六章 数据存储
 */

public class LoginActivity extends BaseActivity {

    private EditText et_account;
    private EditText et_password;
    private Button btn_login;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private CheckBox cb_remember_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter5_login_activity);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        et_account = (EditText) findViewById(R.id.et_account);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        cb_remember_password = (CheckBox) findViewById(R.id.cb_remember_password);

        boolean isRemember = sharedPreferences.getBoolean("remember_password", false);

        if (isRemember) {
            // 如果在SharedPreferences中存储的isRemember为true  则将存储的信息填入编辑框内，并将CheckBox至于true
            String account = sharedPreferences.getString("account", "");
            String password = sharedPreferences.getString("password", "");
            et_account.setText(account);
            et_password.setText(password);
            cb_remember_password.setChecked(true);
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = et_account.getText().toString();
                String password = et_password.getText().toString();

                if (account.equals("admin") && password.equals("111111")) {
                    //  如果通过验证，则认为登录成功,将信息存入SharedPreferences中
                    editor = sharedPreferences.edit();
                    if (cb_remember_password.isChecked()) {
                        editor.putString("account", account);
                        editor.putString("password", password);
                        editor.putBoolean("remember_password", true);
                    } else {
                        editor.clear();  //  清空SharedPreferences
                    }
                    editor.apply();

                    Intent intent = new Intent(LoginActivity.this, OfflineActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
