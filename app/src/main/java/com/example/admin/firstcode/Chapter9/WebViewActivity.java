package com.example.admin.firstcode.Chapter9;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/29.
 */

public class WebViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter9_webview_activity);

        WebView webView  =(WebView)findViewById(R.id.wv_webview);
        webView.getSettings().setJavaScriptEnabled(true);  //  没有这一句 则不会有图片，链接等信息
        webView.setWebViewClient(new WebViewClient());    //  没有这一句 则 会启动手机浏览器 加载百度
        webView.loadUrl("http://www.baidu.com");


    }
}
