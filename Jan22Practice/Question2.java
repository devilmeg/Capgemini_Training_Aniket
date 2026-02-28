package Jan22Practice;
import java.util.HashMap;
import java.util.Map;

class Solution{
	public int countMostFrequent(int arr[]) {
		Map<Integer, Integer> freq = new HashMap<>();
		
		for(int num: arr) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);// if we don't use getOrDefault we will get null if the key does not exist, and null+1 will give nullPointexception
		}
		
		int maxFreq = 0;
		int resultKey = Integer.MAX_VALUE;
		
		for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
			int number = entry.getKey();
			int count = entry.getValue();
			
			if(count > maxFreq) {
				maxFreq = count;
				resultKey = number;
			}else if(count == maxFreq && number < resultKey){
				resultKey =  number;
			}
		}
		return resultKey;
	}
}

public class Question2 {

	public static void main(String[] args) {
		int[] arr = {1, 4, 6, 2, 3, 2, 7, 2 , 3, 3, 1, 1};
		
		Solution sol = new Solution();
		
		int answer = sol.countMostFrequent(arr);
		
		System.out.println("The most frequent element is: "+ answer);
		
		
	}

}
