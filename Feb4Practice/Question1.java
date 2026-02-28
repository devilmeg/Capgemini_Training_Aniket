//Check whether two strings are anagram of each other
package Feb4Practice;

import java.util.HashMap;
import java.util.Map;

class Solution{
	static boolean isAnagram(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		
		Map<Character, Integer> freq = new HashMap<>();
		
		for(char c: s1.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0)+ 1);
		}
		
		for(char c: s2.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0)- 1);
		}
		
		for(Map.Entry<Character, Integer> entry: freq.entrySet()) {
			if(entry.getValue() != 0) {
				return false;
			}
		}
		
		return true;
		
		
	}
}

public class Question1 {

	public static void main(String[] args) {
		
		String s1 = new String("triangle");
		String s2 = new String("integral");
		
		boolean result = Solution.isAnagram(s1, s2);
		
		System.out.println(result);

	}

}
