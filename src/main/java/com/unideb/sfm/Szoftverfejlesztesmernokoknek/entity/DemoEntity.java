package com.unideb.sfm.Szoftverfejlesztesmernokoknek.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USERS")
public class DemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    @Column(name = "BIRTHPLACE")
    private String birthPlace;

    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    // Konstruktorok, getterek és setterek

    public DemoEntity() {
    }

    public DemoEntity(String name, int age, String birthPlace, Date birthDate) {
        this.name = name;
        this.age = age;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
    }

    // Getterek és setterek a tulajdonságokhoz

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "MyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthPlace='" + birthPlace + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
