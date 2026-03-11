package campus;

//package com.campus;

public class StudentRecord {

    private String studentId;
    private String studentName;
    private String eventCode;
    private int score;
    private int originalIndex; // for stable sorting

    public StudentRecord(String studentId, String studentName,
                         String eventCode, int score, int originalIndex) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.eventCode = eventCode;
        this.score = score;
        this.originalIndex = originalIndex;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEventCode() {
        return eventCode;
    }

    public int getScore() {
        return score;
    }

    public int getOriginalIndex() {
        return originalIndex;
    }
}

