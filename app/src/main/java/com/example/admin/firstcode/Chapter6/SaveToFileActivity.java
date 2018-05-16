package com.example.admin.firstcode.Chapter6;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.firstcode.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by wuyue on 2018/5/16.
 * 文件存储
 */

public class SaveToFileActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_save_to_file;

    Button btn_clean_input;
    Button btn_save_input;
    Button btn_load;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter6_save_to_file_activity);
        et_save_to_file = (EditText) findViewById(R.id.et_save_to_file);

        btn_clean_input = (Button) findViewById(R.id.btn_clean_input);
        btn_save_input = (Button) findViewById(R.id.btn_save_input);
        btn_load = (Button) findViewById(R.id.btn_load);
        btn_clean_input.setOnClickListener(this);
        btn_save_input.setOnClickListener(this);
        btn_load.setOnClickListener(this);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String input = et_save_to_file.getText().toString();
        save(input);
    }

    private void save(String input) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("chapter6_data", Context.MODE_APPEND);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_clean_input:
                et_save_to_file.setText("");
                break;
            case R.id.btn_save_input:
                String input = et_save_to_file.getText().toString();
                if (!TextUtils.isEmpty(input.trim())) {
                    save(input);
                    Toast.makeText(this, "save succeeded", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "input is empty", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_load:
                String file = load();
                et_save_to_file.setText(file);
                et_save_to_file.setSelection(file.length());
                if (!TextUtils.isEmpty(et_save_to_file.getText().toString().trim())) {
                    Toast.makeText(this, "load succeeded", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "load failed", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }

    }

    private String load() {

        FileInputStream inputStream = null;
        BufferedReader reader = null;

        StringBuffer buffer = new StringBuffer();

        try {
            inputStream = openFileInput("chapter6_data");
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return buffer.toString();
    }
}
