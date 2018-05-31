package com.example.admin.firstcode.Chapter9.HttpConnectUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.firstcode.R;
import com.example.admin.firstcode.Utils.HttpCallbackListener;
import com.example.admin.firstcode.Utils.HttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by wuyue on 2018/5/31.
 */

public class HttpUtilActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_response_text_util;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter9_http_util_activity);

        Button btn_send_request_http_url_util = findViewById(R.id.btn_send_request_http_url_util);
        btn_send_request_http_url_util.setOnClickListener(this);
        Button btn_send_request_ok_http_util = findViewById(R.id.btn_send_request_ok_http_util);
        btn_send_request_ok_http_util.setOnClickListener(this);
        tv_response_text_util = findViewById(R.id.tv_response_text_util);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_request_http_url_util:
                sendRequestWithHttpURLConnection();
                break;
            case R.id.btn_send_request_ok_http_util:
                sendRequestWithOkHttp();
                break;
            default:
                break;
        }
    }

    private void sendRequestWithHttpURLConnection() {
        String address = "https://www.baidu.com";
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                // 根据返回内容执行具体的逻辑
                showResponse(response);
            }

            @Override
            public void onError(Exception e) {
                // 对异常进行处理
            }
        });

    }

    private void sendRequestWithOkHttp() {
        String address = "https://www.baidu.com";
        HttpUtil.sendOkHttpRequest(address, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 对异常进行处理
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 得到服务器返回具体内容
                String responseData = response.body().string();
                showResponse(responseData);
            }
        });
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //  切换线程 在这里进行UI操作，将结果显示在界面上
                tv_response_text_util.setText(response);
            }
        });
    }
}
