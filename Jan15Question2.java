// to check if a number is palindrome or not 

import java.util.Scanner;

public class Jan15Question2 {
    public static void main(String []args) {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter a number: ");
    	
    	int num = sc.nextInt();
    	
    	int num2 = num;
    	
    	int reverse=0;
    	
    	while(num2 > 0) {
    		int digit = num2%10;
    		
    		reverse = reverse*10 + digit;
    		
    		num2 /= 10;
    	}
    	
    	String result = (reverse == num) ? "Palindrome": "Not a Palindrome";
    	
    	System.out.println(result);
    }
}
