
//package com.company.assessment.problem1;

import org.junit.jupiter.api.Test;

import problem1.LogAnalyzer;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class LogAnalyzerTest {

    @Test
    void testBasicFiltering() {

        LogAnalyzer analyzer = new LogAnalyzer();

        List<String> logs = Arrays.asList(
                "E101,Aniket,PURCHASE,12-05-2023,120",
                "E102,Rahul,VIEW,01-01-2022,30",
                "E103,Amit,LOGIN,10-03-2024,300",
                "E104,Sneha,PURCHASE,25-12-2023,200"
        );

        List<String> result = analyzer.analyzeLogs(logs, 2023, 100);

        assertFalse(result.isEmpty());
        assertTrue(result.get(0).contains(":"));
    }
}
