//import java.util.Scanner;
//import java.util.Stack;
//
//public class BrowserActions {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Stack<String> forward = new Stack<>();
//        Stack<String> backward = new Stack<>();
//        String curTab;
//        String action = sc.nextLine();
//        boolean exit = false;
//        while(!exit){
//            if(action.charAt(0) == '>'){
//                if(!forward.empty()){
//                    curTab = forward.pop();
//                    backward.push(curTab);
//                }
//                else{
//                    System.out.println("No forward task");
//                    exit = true;
//                }
//            }
//            else-if(action.charAt(0) == '<'){
//
//                if(!backward.empty()){
//                    forward.push(backward.pop());
//                    curTab = backward.peek();
//                }
//                else{
//                    System.out.println("no previous task");
//                    exit = true;
//                }
//
//            }
//            else{
//                curTab = action;
//                backward.push(curTab);
//            }
//        }
//    }
//}
