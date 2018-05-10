package com.example.admin.firstcode.Chapter3.Chat;


/**
 * Created by admin on 2018/5/9.
 */

public class Test {
    public static void main(String[] args) {
//        Class a = Animal.class;
//
//        Animal animal =new Animal( "asd",3);
//        Class d= animal.getClass();
//        System.out.println("--"+d);
//        boolean aw =true;
//        Class s=ChatActivity.class.getSuperclass();
//
//
//        System.out.println("--"+s);
//        try {
//            Constructor constructor = a.getConstructor(String.class, int.class);
//            Animal animal = (Animal) constructor.newInstance("da", 5);
//           System.out.println("--".getClass());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

        StringBuffer d =new StringBuffer("123456789");
        d.replace(2,2,"abcd");
        System.out.println(d);

    }
}

class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name :" + name + "  age:" + age;
    }
}

