import java.util.Stack;

public class ParanthesisBalance {
    public static boolean isValid(String text){
        Stack<Character> stack = new Stack<>();
        for(char ch : text.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else{
                if(stack.empty()) return false;
                char top = stack.pop();
                if(ch == ')' && top != '(') return false;
                if(ch == ']' && top != '[') return false;
                if(ch == '}' && top != '{') return false;

            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String text = "{[}]";
        System.out.println(isValid(text));





    }
}
