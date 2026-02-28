// Longest substring without repeating character

package Jan29Practice;

import java.util.Set;
import java.util.HashSet;

class Solution{
	public static String longestSubstring(String s) {
		Set<Character> st = new HashSet<>();
		
		StringBuilder longest = new StringBuilder();
		StringBuilder current = new StringBuilder();
		
		for(char c: s.toCharArray()) {
			boolean added = st.add(c);
			if(added) {
				current.append(c);
				if(current.length() > longest.length()) {
					longest = current;
				}
			}else {
				st.clear();
			}
		}
		
		return longest.toString();
		
	
	}
}	

public class Question1 {
	public static void main(String []args) {
		String str = new String("abcabcbb");
		
		String ans = Solution.longestSubstring(str);
		
		System.out.println(ans);
		 
	}
}

