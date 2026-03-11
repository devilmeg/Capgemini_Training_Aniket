// Sum of all digits in a number

import java.util.Scanner;

public class Jan15Question1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int sum = 0;
		
		while(num > 0) {
			sum += num%10;
			num/=10;
		}
		System.out.println("The sum of digits is " + sum);

	}

}
