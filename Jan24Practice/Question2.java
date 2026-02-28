package Jan24Practice;

import java.util.HashMap;
import java.util.Map;

class Answer{
	public boolean isAnagram(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		if(s1.length() != s2.length()) return false;
		
		Map<Character, Integer> freqS1 = new HashMap<>();
		
		for(char ch: s1.toCharArray()) {
			freqS1.put(ch, freqS1.getOrDefault(ch, 0)+1);
		}
		
		for(char ch: s2.toCharArray()) {
			freqS1.put(ch, freqS1.getOrDefault(ch, 0)-1);
		}
		
		for(Map.Entry<Character, Integer> entry: freqS1.entrySet()) {
			if(entry.getValue() != 0) {
				return false;
			}
		}
		return true;
	}
}

public class Question2 {

	public static void main(String[] args) {
		String s1 = new String("triangle");
		String s2 = new String("integral");
		
		Answer a = new Answer();
		
		boolean result = a.isAnagram(s1, s2);
		
		System.out.println(result);

	}

}
