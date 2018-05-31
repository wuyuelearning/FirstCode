package com.example.admin.firstcode.Utils;

/**
 * Created by wuyue on 2018/5/31.
 * HttpURlConnection 方式请求网络 回调方法
 */

public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
