package com.coderscampus.sort;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWritingService {
    public static void writeStudentsToCSV(List<Student> students, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student student : students) {
                writer.write(student.studentID + "," + student.studentName + "," + student.course + "," + student.grade + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}