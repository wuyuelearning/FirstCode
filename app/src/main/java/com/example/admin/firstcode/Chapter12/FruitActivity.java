package com.example.admin.firstcode.Chapter12;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/6/21.
 *
 * 可折叠式标题栏：CollapsingToolbarLayout
 */

public class FruitActivity extends AppCompatActivity {
    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAGE_ID = "fruit_image_id";


    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView fruit_image;
    TextView fruit_content;

    String fruit_name;
    int fruit_image_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter12_fruit_activity);

        getInfo();

        initView();

        initContent();

    }

    private void getInfo() {
        Intent intent = getIntent();
        fruit_name = intent.getStringExtra(FRUIT_NAME);
        fruit_image_id = intent.getIntExtra(FRUIT_IMAGE_ID, 0);
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.tb_toolbar_2);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.ctl_collapsing_toolbar);
        fruit_image = (ImageView) findViewById(R.id.iv_fruit_image_view);
        fruit_content = (TextView) findViewById(R.id.tv_fruit_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initContent() {
        collapsingToolbarLayout.setTitle(fruit_name);
        Glide.with(this).load(fruit_image_id).into(fruit_image);
        String fruitContent = generaFruitContent(fruit_name);
        fruit_content.setText(fruitContent);
    }

    private String generaFruitContent(String fruit_name) {
        StringBuilder fruitContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            fruitContent.append(fruit_name);
        }
        return fruitContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
