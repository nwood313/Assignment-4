package com.coderscampus.sort;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CSVReader {

    public static void main(String[] args) throws IOException {
        CSVFileService fileService = new CSVFileService("student masterlist.csv");
        // Read CSV file
        List<Student> students = fileService.readCSV();
        // Group students by general course prefix
        Map<String, List<Student>> studentsByGeneralCourse = students.stream()
                .collect(Collectors.groupingBy(student -> getGeneralCoursePrefix(student.getCourse())));

        // Write to new CSV files
        for (Map.Entry<String, List<Student>> entry : studentsByGeneralCourse.entrySet()) {
            String generalCourse = entry.getKey();
            List<Student> studentsInGeneralCourse = entry.getValue();

            // Sort students by grade in descending order
            studentsInGeneralCourse.sort((s1, s2) -> Integer.compare(s2.getGrade(), s1.getGrade()));

            fileService.writeCSV(studentsInGeneralCourse, generalCourse + ".csv");

        }
    }

    private static String getGeneralCoursePrefix(String fullCourseName) {
        // Extract the general course prefix (e.g., "STAT", "APMTH", "COMPSCI")
        return fullCourseName.split(" ")[0];

    }
}
