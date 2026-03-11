package Jan24Practice;

class Solution{
	
	// Chatgpt solution
	
	public String longestWord1(String s) {
		String[] words = s.split(" ");
		String longest = "";
		
		for(String w: words) {
			if(w.length()> longest.length()) {
				longest = w;
			}
		}
		return longest;
	}
	
	public String longestWord(String s) {
		String longest = "";
		String current = "";
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(ch != ' ') {
				current += ch;
			}else {
				if(current.length() > longest.length()) {
					longest = current;
				}
				current = "";
			}
			
		}
		
		if(current.length() > longest.length()) {
			longest = current;
		}
		return longest;
	}
}

public class Question1 {

	public static void main(String[] args) {
		
		String str = new String("Hello World wideweb");
		
		Solution s = new Solution();
		String answer = s.longestWord1(str);
		
		System.out.println(answer);

	}

}
