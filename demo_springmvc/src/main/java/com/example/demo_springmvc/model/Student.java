package com.example.demo_springmvc.model;

public class Student {
    private int id;
    private String name;
    private  int age;
    private boolean gender;
    private String address;


    public Student() {
    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Student(int id, String name, int age, boolean gender, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
