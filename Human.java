package com.example.myapplication;

public class Human {
     private String id;
     private int age;
     private String city;
     private boolean drive;
     private String gender;

    public Human(String id, int age, String city, boolean drive,String gender) {
        this.id = id;
        this.age = age;
        this.city = city;
        this.drive = drive;
        this.gender=gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isDrive() {
        return drive;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDrive(boolean drive) {
        this.drive = drive;
    }
    public String toString(){
        return "name:" +id+ "//birth:"+age+"//city:"+city+"//isDriving:"+drive;
    }




}
