package Feb2Practice;

import java.util.Scanner;

class Answer {
	public static void reverseArray(int arr[]) {
		int size = arr.length;
		
		int i = 0;
		int j = size-1;
		
		while(i <= j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		
		for(int k = 0; k < size; k++) {
			System.out.println(arr[k]+ " ");
		}
		
	}
}

public class Question2 {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of array: ");
		
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		
        System.out.println("Enter the elements of array: ");
		
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		} 
		
		Answer.reverseArray(arr);
	}

}
