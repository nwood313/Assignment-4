package com.coderscampus.sort;

import java.io.*;
import java.util.*;


public class CSVFileService {

    private String filename;

    public CSVFileService(String filename) {
        this.filename = filename;
    }
    public List<Student> readCSV() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                try {
                    int id = Integer.parseInt(data[0]);
                    int grade = Integer.parseInt(data[3]);
                    students.add(new Student(id, data[1], data[2], grade));
                } catch (NumberFormatException e) {
                    System.err.println("Your files have been written and sorted, however I'm TRIGGERRED! because NumberFormatException was caught "
                            + e.getMessage());

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
    public void writeCSV(List<Student> students, String newFilename) {
        try (PrintWriter pw = new PrintWriter(newFilename)) {
            String header = "Student ID, Student Name, Course, Grade";
            pw.println(header);
            for (Student student : students) {
                pw.println(student.getId() + "," + student.getName() + "," + student.getCourse() + "," + student.getGrade());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}