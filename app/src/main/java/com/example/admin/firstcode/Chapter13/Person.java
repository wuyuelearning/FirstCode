package com.example.admin.firstcode.Chapter13;

import java.io.Serializable;

/**
 * Created by wuyue on 2018/6/23.
 */

public class Person implements Serializable {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
