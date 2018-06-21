package com.example.admin.firstcode.Chapter12;

/**
 * Created by wuyue on 2018/6/19.
 */

public class FruitBean {
    private String name;
    private int imageId;

    public FruitBean(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
