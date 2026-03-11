package problem1;

//package com.company.assessment.problem1;

public class LogRecord {

    String eventId;
    String userName;
    String eventType;
    String eventDate;
    int duration;

    public LogRecord(String eventId, String userName,
                     String eventType, String eventDate, int duration) {

        this.eventId = eventId;
        this.userName = userName;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.duration = duration;
    }
}
