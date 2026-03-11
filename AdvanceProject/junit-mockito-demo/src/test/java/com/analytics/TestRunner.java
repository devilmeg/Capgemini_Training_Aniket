package com.analytics;

import com.ActionAnalytics;
import com.ActionType;
import com.BatchActionAnalyticsImpl;

public class TestRunner {

    public static void main(String[] args) {

        // Create analytics engine with batch size = 3
        ActionAnalytics analytics = new BatchActionAnalyticsImpl(3);

        // Record actions
        analytics.recordAction(ActionType.LOGIN);
        analytics.recordAction(ActionType.LOGOUT);
        analytics.recordAction(ActionType.LOGIN);
        analytics.recordAction(ActionType.VIEW);
        analytics.recordAction(ActionType.LOGIN);
        analytics.recordAction(ActionType.VIEW);

        // Process batches
        analytics.processNextBatch();
        analytics.processNextBatch();

        // Print analytics
        System.out.println("Total processed: " + analytics.getTotalProcessedCount());
        System.out.println("Pending actions: " + analytics.getPendingActionCount());
        System.out.println("Most frequent actions: " + analytics.getMostFrequentActions());
    }
}