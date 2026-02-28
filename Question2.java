// remove the last digit of a number and print the number
// 124  --> 12

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number: ");
		int num = sc.nextInt();
		
		num /= 10;
		
		System.out.println(num);
		
		
	}

}
