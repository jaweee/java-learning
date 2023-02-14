package com.jaweee.basic.reflect;

/**
 * @author: me
 * @title: Student
 * @description:
 * @date: 2023/2/14 20:35
 */
public class Student {

    private String name;

    private Integer age;

    private Integer gender;

    public Student() {

    }

    public Student(String name, Integer age, Integer gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
