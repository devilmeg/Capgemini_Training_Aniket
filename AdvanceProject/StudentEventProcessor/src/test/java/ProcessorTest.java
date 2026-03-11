//package com.campus;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import campus.Processor;
import campus.StudentRecord;

public class ProcessorTest {

    @Test
    public void testProcessRecords_basicScenario() {

        List<StudentRecord> records = new ArrayList<>();

        records.add(new StudentRecord("S101", "John Doe", "CSE101", 85, 0));
        records.add(new StudentRecord("S102", "Alice Smith", "EEE200", 90, 1));
        records.add(new StudentRecord("S103", "Bob Ray", "CSE202", 85, 2));
        records.add(new StudentRecord("S104", "Charlie Brown", "CSE101", 92, 3));
        records.add(new StudentRecord("S105", "David Miller", "CSE303", 85, 4));

        int threshold = 85;

        List<StudentRecord> result =
                Processor.processRecords(records, threshold);

        assertEquals(4, result.size());

        assertEquals("S104", result.get(0).getStudentId());
        assertEquals("S101", result.get(1).getStudentId());
        assertEquals("S103", result.get(2).getStudentId());
        assertEquals("S105", result.get(3).getStudentId());
    }

    @Test
    public void testStableSorting_sameScoreSameNameLength() {

        List<StudentRecord> records = new ArrayList<>();

        records.add(new StudentRecord("S201", "A B", "C101", 80, 0));
        records.add(new StudentRecord("S202", "C D", "C102", 80, 1));
        records.add(new StudentRecord("S203", "E F", "C103", 80, 2));

        int threshold = 80;

        List<StudentRecord> result =
                Processor.processRecords(records, threshold);

        assertEquals("S201", result.get(0).getStudentId());
        assertEquals("S202", result.get(1).getStudentId());
        assertEquals("S203", result.get(2).getStudentId());
    }

    @Test
    public void testFiltering_eventCodeAndThreshold() {

        List<StudentRecord> records = new ArrayList<>();

        records.add(new StudentRecord("S301", "Alpha", "C100", 70, 0));
        records.add(new StudentRecord("S302", "Beta", "E200", 95, 1));
        records.add(new StudentRecord("S303", "Gamma", "C300", 90, 2));

        int threshold = 80;

        List<StudentRecord> result =
                Processor.processRecords(records, threshold);

        assertEquals(1, result.size());
        assertEquals("S303", result.get(0).getStudentId());
    }
}

