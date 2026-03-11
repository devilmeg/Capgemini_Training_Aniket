package campus;

//package com.campus;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        List<StudentRecord> records = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();

            // Split while keeping names with spaces
            String[] parts = line.split(" ");
            String studentId = parts[0];
            String eventCode = parts[parts.length - 2];
            int score = Integer.parseInt(parts[parts.length - 1]);

            // Reconstruct name
            StringBuilder nameBuilder = new StringBuilder();
            for (int j = 1; j < parts.length - 2; j++) {
                nameBuilder.append(parts[j]).append(" ");
            }

            String studentName = nameBuilder.toString().trim();

            records.add(new StudentRecord(
                    studentId, studentName, eventCode, score, i
            ));
        }

        int thresholdScore = Integer.parseInt(sc.nextLine());

        List<StudentRecord> result =
                Processor.processRecords(records, thresholdScore);

        for (StudentRecord r : result) {
            System.out.println(
                    r.getStudentId() + "|" +
                    Processor.transformName(r.getStudentName()) + "|" +
                    r.getEventCode() + "|" +
                    r.getScore()
            );
        }

        sc.close();
    }
}

