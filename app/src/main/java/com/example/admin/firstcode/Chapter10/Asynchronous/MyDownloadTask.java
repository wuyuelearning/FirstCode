package com.example.admin.firstcode.Chapter10.Asynchronous;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by wuyue on 2018/6/7.
 */

public class MyDownloadTask extends AsyncTask<Void ,Integer,Boolean>{
    ProgressDialog progressDialog;
    @Override
    protected void onPreExecute() {

        progressDialog.show();//  显示进度对话框
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        // 更新下载进度
        progressDialog.setMessage("Downloaded"+values[0]+"%");
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {

        progressDialog.dismiss();  //  关闭进度对话框
        // 提示下载结果
        if(aBoolean){

        }else {

        }
    }
}
