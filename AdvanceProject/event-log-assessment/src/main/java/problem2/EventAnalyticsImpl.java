package problem2;

//package com.company.assessment.problem2;

import java.util.*;

public class EventAnalyticsImpl implements EventAnalytics {

    private final int batchSize;
    private Queue<EventType>q;
    private Map<EventType,Integer>map;
    private int totalProcessed;
    // WRITE YOUR DATA STRUCTURES HERE

    public EventAnalyticsImpl(int batchSize) {
        this.batchSize = batchSize;
        this.q=new LinkedList<>();
        this.map=new HashMap<>();
        this.totalProcessed=0;       

        // INITIALIZE STRUCTURES
    }

    @Override
    public void recordEvent(EventType type) {

        // WRITE YOUR CODE HERE
    	q.offer(type);
    	if(q.size()==batchSize) {
    		processBatch();
    		q.clear();
    	}
    }

    @Override
    public void processBatch() {

        // WRITE YOUR CODE HERE
    	while(!q.isEmpty()) {
    		EventType e=q.poll();
    		map.put(e, map.getOrDefault(e,0)+1);
    		totalProcessed++;
    	}
    }

    @Override
    public int getTotalProcessedCount() {

        // WRITE YOUR CODE HERE
    	
        return totalProcessed++;
    }

    @Override
    public int getPendingCount() {

        // WRITE YOUR CODE HERE
        return q.size();
    }

    @Override
    public List<EventType> getMostFrequentEventTypes() {

        // WRITE YOUR CODE HERE
        return new ArrayList<>();
    }
}

