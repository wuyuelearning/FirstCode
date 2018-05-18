package com.example.admin.firstcode.Chapter6.EarlyPartData;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/16.
 * SharedPreFerencesd存储信息
 */

public class SharedPreferencesActivity extends AppCompatActivity {

    Button btn_save_sharedpreferaences;
    Button btn_load_sharedpreferaences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter6_sharedpreferences_activity);

        btn_save_sharedpreferaences = (Button) findViewById(R.id.btn_save_sharedpreferaences);
        btn_load_sharedpreferaences = (Button) findViewById(R.id.btn_load_sharedpreferaences);

        btn_save_sharedpreferaences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("chapter6_data_2", MODE_PRIVATE).edit();
                editor.putString("name", "Tom");
                editor.putInt("age", 28);
                editor.putBoolean("married", false);
                editor.apply();
                Toast.makeText(getApplicationContext(), "save succeeced", Toast.LENGTH_SHORT).show();

            }
        });

        btn_load_sharedpreferaences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("chapter6_data_2", MODE_PRIVATE);
                String name = sharedPreferences.getString("name", "");
                int age = sharedPreferences.getInt("age", 0);
                boolean married = sharedPreferences.getBoolean("married", false);
                Toast.makeText(getApplicationContext(), "name: " + name + "  age: " + age + "  married:  " + married, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
