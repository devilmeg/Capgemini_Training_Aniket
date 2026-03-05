//Valid Parentheses
package Feb18Practice;

import java.util.Stack;

class ValidBrackets{
	public static boolean validBrackets(String s) {
		Stack<Character> st = new Stack<>();
		
		for(char ch: s.toCharArray()) {
			if(ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			}
			else {
				if (st.isEmpty()) {
                    return false;
                }
				
			    char top = st.peek();
				if((ch == '}' && top == '{') || (ch == ')' && top == '(') || (ch == ']' && top == '[')) {
					st.pop();
				}else {
					return false;
				}	
			}
			
		}
		return st.isEmpty();
	}
}

public class Question1 {

	public static void main(String[] args) {
		System.out.println(ValidBrackets.validBrackets("(){}[]")); 
        System.out.println(ValidBrackets.validBrackets("(]"));    
        System.out.println(ValidBrackets.validBrackets("([)]"));   
        System.out.println(ValidBrackets.validBrackets("{[]}"));  
	}

}
