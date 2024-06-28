package com.coderscampus.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentCSVProcessor {
    public static void main(String[] args) {
        String csvFile = "student masterlist.csv";
        String line;
        String csvSplitBy = ",";
        List<Student> mathStudents = new ArrayList<>();
        List<Student> scienceStudents = new ArrayList<>();
        List<Student> historyStudents = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);
                if (values.length != 4) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }
                int id;
                String course;
                int grade;
                String name;
                try {
                    id = Integer.parseInt(values[0]);
                    name = values[1];
                    course = values[2];
                    grade = Integer.parseInt(values[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping line due to NumberFormatException: " + line);
                    continue;
                }

                Student student = new Student(id, name, course, grade);

                // Add student to the appropriate course list
                switch (course) {
                    case "COMPSCI":
                        mathStudents.add(student);
                        break;
                    case "STAT":
                        scienceStudents.add(student);
                        break;
                    case "APMTH":
                        historyStudents.add(student);
                        break;
                }
            }

            // Sort students by grade in descending order
            Comparator<Student> gradeComparator = Comparator.comparingInt(Student::getGrade);
            mathStudents.sort(gradeComparator.reversed());
            scienceStudents.sort(gradeComparator.reversed());
            historyStudents.sort(gradeComparator.reversed());

            // Write sorted data to separate CSV files
            writeStudentsToCSV(mathStudents,    "course1.csv");
            writeStudentsToCSV(scienceStudents, "course2.csv");
            writeStudentsToCSV(historyStudents, "course3.csv");

            System.out.println("Data written to CSV files successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeStudentsToCSV(List<Student> students, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student student : students) {
                writer.write(student.studentID + "," + student.studentName + "," + student.course + "," + student.grade + "\n");
            }
            writer.flush(); // Flush the buffer to ensure data is written
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
