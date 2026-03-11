package campus;

//package com.campus;

import java.util.*;

public class Processor {

    /**
     * IMPLEMENT ONLY THIS METHOD
     */
	public static List<StudentRecord> processRecords(
	        List<StudentRecord> records,
	        int thresholdScore) {

	    // Step 1: Filter records
	    List<StudentRecord> filtered = new ArrayList<>();

	    for (StudentRecord r : records) {
	        if (r.getEventCode().startsWith("C") &&
	            r.getScore() >= thresholdScore) {
	            filtered.add(r);
	        }
	    }

	    // Step 2: Stable sort using Comparator
	    Collections.sort(filtered, new Comparator<StudentRecord>() {
	        @Override
	        public int compare(StudentRecord a, StudentRecord b) {

	            // Primary key: Score descending
	            if (a.getScore() != b.getScore()) {
	                return b.getScore() - a.getScore();
	            }

	            // Do NOT apply secondary sorting
	            // Preserve original order (stable sort)
	            return a.getOriginalIndex() - b.getOriginalIndex();
	        }
	    });


	    return filtered;
	}

    // Helper method (already written)
    public static String transformName(String name) {
        return name.replaceAll("\\s+", "").toUpperCase();
    }
}
