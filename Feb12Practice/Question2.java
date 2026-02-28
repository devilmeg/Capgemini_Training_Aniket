package Feb12Practice;

import java.util.*;

class AnalyticsTracker {
	
	private List<String> lastBatch;
	private Queue<String> buffer;
	private Map<String, Integer> freq;
	private int K;
	private int totalLogged;

    public AnalyticsTracker(int K) {
    	buffer = new LinkedList<>();
    	freq = new HashMap<>();
    	this.K = K;
    	totalLogged = 0;
    }

    public void registerAction(String action) {
    	buffer.add(action);
    	freq.put(action, freq.getOrDefault(action, 0)+1);
    	totalLogged++;
    	
    	if(buffer.size() == K) {
    		lastBatch = new ArrayList<>(buffer);
    		buffer.clear();
    	}
    }

    public int getPendingCount() {
    	return buffer.size();
    }

    public int getTotalLoggedActions() {
    	return totalLogged;
    }

    public List<String> getMostFrequentActions(){
    	int max = 0;
    	List<String> mostFrequentAction = new ArrayList<>();
    	for(Map.Entry<String, Integer> entry: freq.entrySet()) {
    		String key = entry.getKey();
    		int value = entry.getValue();
    		
    		if(value > max) {
    			mostFrequentAction.clear();
    			mostFrequentAction.add(key);
    			max = value;
    		}else if(value == max) {
    			mostFrequentAction.add(key);
    		}
    	}
    	
    	Collections.sort(mostFrequentAction);
    	
    	return mostFrequentAction;
    }
}


public class Question2 {

	public static void main(String[] args) {
	

	}

}
