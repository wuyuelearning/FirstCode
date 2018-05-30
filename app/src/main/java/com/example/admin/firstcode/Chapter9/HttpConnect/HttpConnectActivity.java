package com.example.admin.firstcode.Chapter9.HttpConnect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.firstcode.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wuyue on 2018/5/29.
 */

public class HttpConnectActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_response_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter9_http_url_connection_activity);
        Button btn_send_request_http_url = findViewById(R.id.btn_send_request_http_url);
        btn_send_request_http_url.setOnClickListener(this);
        Button btn_send_request_ok_http = findViewById(R.id.btn_send_request_ok_http);
        btn_send_request_ok_http.setOnClickListener(this);
        tv_response_text = findViewById(R.id.tv_response_text);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_request_http_url:
                sendRequestWithHttpURLConnection();
                break;
            case R.id.btn_send_request_ok_http:
                sendRequestWithOkHttp();
                break;
            default:
                break;
        }
    }

    private void sendRequestWithHttpURLConnection() {
        // 开启线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                BufferedReader reader =null;
                try {
                    URL url = new URL("http://www.baidu.com");
                    httpURLConnection =(HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(8000);
                    InputStream inputStream = httpURLConnection.getInputStream();
                    // 对获取的输入流进行读取
                    reader =new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder builder =new StringBuilder();
                    String line;
                    while((line = reader.readLine())!=null){
                        builder.append(line);
                    }
                    showResponse(builder.toString());
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    if(reader != null){
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if(httpURLConnection != null){
                            httpURLConnection.disconnect();
                        }
                    }
                }
            }
        }).start();
    }


    private void sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client =new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://www.baidu.com")
                            .build();

                    Response response = client.newCall(request).execute();
                    String responseData  = response.body().string();
                    showResponse(responseData);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showResponse(final String response){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //  在这里进行UI操作，将结果显示在界面上
                tv_response_text.setText(response);
            }
        });
    }
}
