//package com.company.assessment.problem2;

import org.junit.jupiter.api.Test;

import problem2.EventAnalytics;
import problem2.EventAnalyticsImpl;
import problem2.EventType;

import static org.junit.jupiter.api.Assertions.*;

class EventAnalyticsTest {

    @Test
    void testBatchProcessing() {

        EventAnalytics analytics = new EventAnalyticsImpl(3);

        analytics.recordEvent(EventType.LOGIN);
        analytics.recordEvent(EventType.VIEW);
        analytics.recordEvent(EventType.LOGIN);

        assertEquals(3, analytics.getTotalProcessedCount());
        assertEquals(0, analytics.getPendingCount());
    }
}
