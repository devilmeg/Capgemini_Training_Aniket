package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import com.ActionType;
import com.ActionAnalytics;

public class BatchActionAnalyticsImpl implements ActionAnalytics {

    private final int batchSize;
    
    private Queue<ActionType> pendingQueue;
    
    private Map<ActionType,Integer> freq;
    
    private int totalProcess;

    public BatchActionAnalyticsImpl(int batchSize) {
        this.batchSize = batchSize;
        // initialize required data structures
        this.pendingQueue=new LinkedList<>();
        this.freq=new HashMap<>();
        this.totalProcess=0;
    }

    @Override
    public void recordAction(ActionType action) {
        // WRITE YOUR CODE HERE
    	pendingQueue.offer(action);
    }

    @Override
    public void processNextBatch() {
        // WRITE YOUR CODE HERE
    	int processedInThisbatch=0;
    	
    	while(!pendingQueue.isEmpty() && processedInThisbatch<batchSize) {
    		
    		ActionType action=pendingQueue.poll();
    		
    		freq.put(action,freq.getOrDefault(action,0)+1);
    		totalProcess++;
    		processedInThisbatch++;
    		
    	}
    	
    }

    @Override
    public int getTotalProcessedCount() {
        // WRITE YOUR CODE HERE
        return totalProcess;
    }

    @Override
    public int getPendingActionCount() {
        // WRITE YOUR CODE HERE
        return pendingQueue.size();
    }

    @Override
    public List<ActionType> getMostFrequentActions() {
        // WRITE YOUR CODE HERE
    	
    	List<ActionType>res=new ArrayList<>();
    	if(freq.isEmpty()) {
    		return res;
    	}
    	
    	int max=0;
    	for(int c:freq.values()) {
    		max=Math.max(max, c);
    	}
    	
    	for(Map.Entry<ActionType,Integer>e :freq.entrySet()){
    		if(e.getValue()==max) {
    			res.add(e.getKey());
    		}
    	}
    	Collections.sort(res,Comparator.comparing(Enum::name));
        return new ArrayList<>();
    }
}
