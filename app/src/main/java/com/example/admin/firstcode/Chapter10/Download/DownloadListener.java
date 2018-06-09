package com.example.admin.firstcode.Chapter10.Download;

/**
 * Created by wuyue on 2018/6/9.
 */

public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPause();

    void onCanceled();
}
