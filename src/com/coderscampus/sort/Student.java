package com.coderscampus.sort;

public class Student {
    int studentID;
    String studentName;
    String course;
    int grade;

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    Student(int id, String name, String course, int grade) {
        this.studentID = id;
        this.studentName = name;
        this.course = course;
        this. grade = grade;
    }

}
