//Second most frequent element

package Jan27Practice;

import java.util.HashMap;
import java.util.Map;

class Solution{
	
	public static int secondMostFrequent(int[] arr) {
	    Map<Integer, Integer> freq = new HashMap<>();

	    for (int num : arr) {
	        freq.put(num, freq.getOrDefault(num, 0) + 1);
	    }

	    int maxFreq = 0;
	    int secondMaxFreq = 0;

	    for (int count : freq.values()) {
	        if (count > maxFreq) {
	            secondMaxFreq = maxFreq;
	            maxFreq = count;
	        } else if (count < maxFreq && count > secondMaxFreq) {
	            secondMaxFreq = count;
	        }
	    }

	    if (secondMaxFreq == 0) return -1;

	    int result = Integer.MAX_VALUE;

	    for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
	        if (entry.getValue() == secondMaxFreq && entry.getKey() < result) {
	            result = entry.getKey();
	        }
	    }

	    return result == Integer.MAX_VALUE ? -1 : result;
	}
	
}

public class Question3 {

	public static void main(String[] args) {
		int arr[] = {2, 2, 5, 6, 7, 7, 7, 4, 2, 2, 4};
		
		int answer = Solution.secondMostFrequent(arr);
		
		System.out.println("The second most frequent element "+ answer);

	}

}
