package Feb18Practice;

import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

class RemoveDuplicates{
	public static String removeDuplicates(String s) {
		Stack<Character> st = new Stack<>();
		
		for(char ch: s.toCharArray()) {
			if(st.isEmpty()) {
				st.push(ch);
			}else {
				if(ch == st.peek()) {
					st.pop();
				}else {
					st.push(ch);
				}
			}
		}
		
		StringBuilder ans = new StringBuilder();
		
		while(!st.isEmpty()) {
			ans.append(st.pop());
		}
		
		return ans.reverse().toString()	;	
	}
}

public class Question2 {

	public static void main(String[] args) {
		System.out.println(RemoveDuplicates.removeDuplicates("abbaca"));
	}

}
