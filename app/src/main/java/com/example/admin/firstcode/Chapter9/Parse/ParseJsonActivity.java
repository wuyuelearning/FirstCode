package com.example.admin.firstcode.Chapter9.Parse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.firstcode.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wuyue on 2018/5/30.
 */

public class ParseJsonActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isJsonObject = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter9_parse_json_activity);

        Button btn_parse_json_jsonobject = (Button) findViewById(R.id.btn_parse_json_jsonobject);
        btn_parse_json_jsonobject.setOnClickListener(this);
        Button btn_parse_json_gson = (Button) findViewById(R.id.btn_parse_json_gson);
        btn_parse_json_gson.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_parse_json_jsonobject:
                isJsonObject = true;
                break;
            case R.id.btn_parse_json_gson:
                isJsonObject = false;
                break;
            default:
                break;
        }
        sendRequestWithOkHttp();
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    if (isJsonObject) {
                        Request request = new Request.Builder()
                                .url("http://127.0.0.1/get_data_jsonobject.json")
                                .build();
                        Response response = client.newCall(request).execute();
                        String responseData = response.body().string();
                        parseJsonWithJsonObject(responseData);
                    } else {
                        Request request = new Request.Builder()
                                .url("http://127.0.0.1/get_data_gson.json")
                                .build();
                        Response response = client.newCall(request).execute();
                        String responseData = response.body().string();
                        parseJsonWithGson(responseData);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJsonWithJsonObject(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                Log.d("tag_json", "id is " + id);
                Log.d("tag_json", "name is " + name);
                Log.d("tag_json", "version is " + version);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseJsonWithGson(String jsonData) {
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>() {
        }.getType());
        for (App app : appList) {
            Log.d("tag_json", "id is " + app.getId());
            Log.d("tag_json", "name is " + app.getName());
            Log.d("tag_json", "version is " + app.getVersion());
        }
    }
}
