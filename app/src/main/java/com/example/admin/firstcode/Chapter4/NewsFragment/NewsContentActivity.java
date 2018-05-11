package com.example.admin.firstcode.Chapter4.NewsFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.firstcode.R;



/**
 * Created by wuyue on 2018/5/11.
 */

public class NewsContentActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter4_news_content_fragment_single);

        String title =getIntent().getStringExtra("newsTitle");
        String content = getIntent().getStringExtra("newsContent");

        NewsContentFragment newsContentFragment = (NewsContentFragment)getSupportFragmentManager().findFragmentById(R.id.fg_news_content_fragment);
        newsContentFragment.refresh(title,content);
    }

    public static void actionStart (Context context ,String title ,String content){
        Intent intent = new Intent(context ,NewsContentActivity.class);
        intent.putExtra("newsTitle",title);
        intent.putExtra("newsContent",content);
        context.startActivity(intent);
     }
}
