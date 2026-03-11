package problem2;

//package com.company.assessment.problem2;

import java.util.List;

public interface EventAnalytics {

    void recordEvent(EventType type);

    void processBatch();

    int getTotalProcessedCount();

    int getPendingCount();

    List<EventType> getMostFrequentEventTypes();
}
