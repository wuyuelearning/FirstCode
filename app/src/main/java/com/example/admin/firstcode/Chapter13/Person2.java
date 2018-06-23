package com.example.admin.firstcode.Chapter13;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wuyue on 2018/6/23.
 */

public class Person2 implements Parcelable {

    private String name;
    private String address;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }


    public static final Creator<Person2> CREATOR = new Creator<Person2>() {
        @Override
        public Person2 createFromParcel(Parcel in) {

            Person2 person2 = new Person2();
            // 需要和 writeToParcel 方法 写入的顺序相同
            person2.name = in.readString();  // 读取name
            person2.age = in.readInt();    //  读取age
            person2.address = in.readString();  // 读取address

            return person2;
        }

        @Override
        public Person2[] newArray(int size) {
            return new Person2[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);  // 写出name
        dest.writeInt(age);   //  写出age
        dest.writeString(address); // 写出address

    }
}
