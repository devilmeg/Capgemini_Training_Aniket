package Feb6Practice;

import java.util.Scanner;

class SquareRoot{
	static double squareRoot(int n) {
		double low = 0, high = n;
        double mid;

        for (int i = 0; i < 100; i++) {
            mid = (low + high) / 2;
            if (mid * mid <= n) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
	}
}

public class Question2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		System.out.println(SquareRoot.squareRoot(num));

	}

}
