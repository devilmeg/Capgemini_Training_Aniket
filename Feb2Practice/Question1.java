package Feb2Practice;

import java.util.Scanner;

class Solution{
	public static boolean identicalCheck(int arr1[], int arr2[]) {
		int size1 = arr1.length;
		int size2 = arr2.length;
		
		if(size1 != size2) return false;
		
		for(int i = 0; i < size1; i++) {
			if(arr1[i] != arr2[i]) return false;
		}
		
		return true;	
	}
}

public class Question1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of first array: ");
		
		int size1 = sc.nextInt();
		
		System.out.println("Enter the size of second array: ");
		
		int size2 = sc.nextInt();
		
		if(size1 != size2) {
			System.out.println("The size of two arrays must be same");
		};
		
		int arr1[] = new int[size1];
		int arr2[] = new int[size2];
		
		System.out.println("Enter the elements of first array: ");
		
		for(int i = 0; i < size1; i++) {
			arr1[i] = sc.nextInt();
		}
		
        System.out.println("Enter the elements of second array: ");
		
		for(int i = 0; i < size2; i++) {
			arr2[i] = sc.nextInt();
		}
		
		boolean ans = Solution.identicalCheck(arr1, arr2);
		
		System.out.println(ans);
	}

}
