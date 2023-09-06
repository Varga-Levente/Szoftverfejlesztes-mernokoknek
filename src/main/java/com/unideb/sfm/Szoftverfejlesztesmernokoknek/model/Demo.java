package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import java.util.Date;

public class Demo {
    String name;
    int age;
    String birthPlace;
    Date birthDate;

    public Demo(String name, int age, String birthPlace, Date birthDate) {
        this.name = name;
        this.age = age;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "<b>{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthPlace='" + birthPlace + '\'' +
                ", birthDate=" + birthDate +
                "}</b><br>";
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

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
