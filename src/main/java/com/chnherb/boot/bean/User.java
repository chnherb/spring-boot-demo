package com.chnherb.boot.bean;

public class User {
    int number;
    String name;
    int age;

    public User() {

    }
    public User(int number, String name, int age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

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
