package com.bcit.aaron_midterm;

import java.io.Serializable;

public class Hippo implements Serializable {

    String name;
    int age;
    String food;
    int resId;

    public Hippo(String name, int age, String food, int resId) {
        this.name = name;
        this.age = age;
        this.food = food;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFood() {
        return food;
    }

    public int getResId() {
        return resId;
    }
}
