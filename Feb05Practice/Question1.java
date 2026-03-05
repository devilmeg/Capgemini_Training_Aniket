package Feb05Practice;
import java.util.Stack;

class Solution{
	static boolean validParantheses(String s) {
		Stack<Character> st = new Stack<>();
		
		for(char ch: s.toCharArray()) {
			
			if(ch == '{' || ch == '[' || ch == '(') {
				st.push(ch);
			}else {
				if(st.empty()) {
					return false;
				}
				
				char top = st.peek();
				
					if((ch == '}' && top == '{') ||
					   (ch == ']' && top == '[') ||
					   (ch == ')' && top == '(')) {
						st.pop();
				}else {
					return false;
				}
			}
			
		}
		
		return st.empty();
		
	}
}

public class Question1 {

	public static void main(String[] args) {
		
		String s1 = new String("[{()}]");
		String s2 = new String("[}]{");
		String s3 = new String("[({[]])}");
		
		
		System.out.println(Solution.validParantheses(s1));
	}

}
