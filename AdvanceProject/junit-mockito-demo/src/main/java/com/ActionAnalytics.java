package com;

import java.util.List;

public interface ActionAnalytics {

    void recordAction(ActionType action);

    void processNextBatch();

    int getTotalProcessedCount();

    int getPendingActionCount();

    List<ActionType> getMostFrequentActions();
}
