package com.coderscampus.sort;

public class Student {
    Integer id;
    String name;
    String course;
    Integer grade;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    public Student(Integer id, String name, String course, Integer grade) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.grade = grade;

    }
}