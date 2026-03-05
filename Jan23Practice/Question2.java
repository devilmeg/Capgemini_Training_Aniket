package Jan23Practice;

import java.util.Map;
import java.util.LinkedHashMap;

class Answer{
	public char firstUniqueChar(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0)+ 1);
		}
		
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return ' ';
		
	}
}

public class Question2 {

	public static void main(String[] args) {
		Answer a = new Answer();
		
		String str = new String("leetcode");
		
		char answer = a.firstUniqueChar(str);
		
		System.out.println("The first non repeating character is: "+ answer);

	}

}
