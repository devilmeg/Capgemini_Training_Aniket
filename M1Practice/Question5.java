package M1Practice;

import java.util.*;

class ActionTracker {
	
	Queue<String> buffer;
	List<String> lastBatch;
	private int K;
	private int batchesSent;
	
    public ActionTracker(int K) {
    	this.K = K;
    	buffer = new ArrayDeque<>();
    	lastBatch = new ArrayList<>();
    	batchesSent = 0;
    }

    public void registerAction(String action) {
    	buffer.add(action);
    	
    	if(buffer.size() == K) {
    		lastBatch = new ArrayList<>(buffer);
    		buffer.clear();
    		batchesSent++;
    	}
    }

    public int getPendingCount() {
    	return buffer.size();
    }

    public int getTotalSentBatches() {
    	return batchesSent;
    }

    public List<String> getLastBatch(){
    	return lastBatch;
    }
}

public class Question5 {

    public static void main(String[] args) {

        ActionTracker tracker = new ActionTracker(3);

        tracker.registerAction("LOGIN");
        tracker.registerAction("CLICK");
        
        System.out.println("Pending count: " + tracker.getPendingCount());       // 2
        System.out.println("Total sent batches: " + tracker.getTotalSentBatches()); // 0
        System.out.println("Last batch: " + tracker.getLastBatch());             // []

        tracker.registerAction("SCROLL");

        System.out.println("\nAfter SCROLL:");
        System.out.println("Pending count: " + tracker.getPendingCount());       // 0
        System.out.println("Total sent batches: " + tracker.getTotalSentBatches()); // 1
        System.out.println("Last batch: " + tracker.getLastBatch());             // [LOGIN, CLICK, SCROLL]

        tracker.registerAction("LOGOUT");

        System.out.println("\nAfter LOGOUT:");
        System.out.println("Pending count: " + tracker.getPendingCount());       // 1
        System.out.println("Total sent batches: " + tracker.getTotalSentBatches()); // 1
        System.out.println("Last batch (unchanged): " + tracker.getLastBatch());
    }
}


