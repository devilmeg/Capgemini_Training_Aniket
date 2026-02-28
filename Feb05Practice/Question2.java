package Feb05Practice;

import java.util.HashSet;
import java.util.Set;

class Answer{
	static int lengthOfLongestSubstring(String s) {
		Set<Character> st = new HashSet<>();
		
		int i = 0;
		int j = 0;
		int answer = 0;
		
		while(j < s.length()) {
			char ch = s.charAt(j);
			
			if(!st.contains(ch)) {
				st.add(ch);
				j++;
				answer = Math.max(answer, j-i);
			}else {
				st.remove(s.charAt(i));
				i++;
			}
		}
		
		return answer;
	}
}

public class Question2 {

	public static void main(String[] args) {
		String str = new String("aabdcfbde");
		
		int answer = Answer.lengthOfLongestSubstring(str);
		
		System.out.println(answer);

	}

}
