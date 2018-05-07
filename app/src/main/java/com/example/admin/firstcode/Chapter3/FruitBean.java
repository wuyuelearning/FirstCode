package com.example.admin.firstcode.Chapter3;

/**
 * Created by admin on 2018/5/7.
 */

public class FruitBean {

    private String name;
    private int imageId;

    public FruitBean (String name ,int imageId){
        this.name =name;
        this.imageId =imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
