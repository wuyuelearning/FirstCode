package com.example.admin.firstcode.Chapter3.RecyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.admin.firstcode.Chapter3.FruitBean;
import com.example.admin.firstcode.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wuyue on 2018/5/7.
 */

public class RecyclerViewAcrivity extends AppCompatActivity {
    private List<FruitBean> fruitBeanList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter3_recyclerview_activity);
        initData();
//        initDataForStaggeredGrid();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_recycler_view);
//        //  线性垂直布局,
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        // 线性水平布局 需要在RecycleViewApdater中修改Item布局
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        // 栅格布局
//        GridLayoutManager layoutManager =new GridLayoutManager(this,4);

        // 瀑布流布局
//        StaggeredGridLayoutManager layoutManager =new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        RecycleViewApdater apdater = new RecycleViewApdater(fruitBeanList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(apdater);
    }

    private void initData() {
        for (int i = 0; i < 200; i++) {
            FruitBean apple = new FruitBean("apple", R.drawable.chapter3_selected);
            fruitBeanList.add(apple);
            FruitBean banana = new FruitBean("banana", R.drawable.chapter3_unselected);
            fruitBeanList.add(banana);
        }
    }

    private void initDataForStaggeredGrid() {
        for (int i = 0; i < 200; i++) {
            FruitBean apple = new FruitBean(getRandomLengthName("apple"), R.drawable.chapter3_selected);
            fruitBeanList.add(apple);
            FruitBean banana = new FruitBean(getRandomLengthName("banana"), R.drawable.chapter3_unselected);
            fruitBeanList.add(banana);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }
}
