package Jan23Practice;

import java.util.Map;
import java.util.HashMap;

class Solution{
	public char mostFrequentChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		
		for(char c: s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+ 1);
		}
		
		char result = '{';
		int maxFreq = 0;
		
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			int number = entry.getValue();
			char currentChar = entry.getKey();
			if (number > maxFreq || (number == maxFreq && currentChar < result)) {
	            maxFreq = number;
	            result = currentChar;
	        }
		}
		return result;
	}
}

public class Question1 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		String str = new String("aaabbcdeeaddddeee");
		
		char answer = s.mostFrequentChar(str);
		
		System.out.println("The most frequent character is: " + answer);

	}

}
