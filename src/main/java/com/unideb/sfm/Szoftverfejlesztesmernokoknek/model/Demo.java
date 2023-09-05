package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import java.util.Date;

public class Demo {
    String id;
    String name;
    String age;
    String birthPlace;
    String birthDate;

    public Demo(String id, String name, String age, String birthPlace, String birthDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "<b>{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthPlace='" + birthPlace + '\'' +
                ", birthDate=" + birthDate +
                "}</b><br>";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
