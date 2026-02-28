import java.util.Scanner;

public class Jan16Question1 {
	
	static int searchElement(int n, int[] arr) {
		for(int i = 0; i <arr.length; i++) {
			if(arr[i] == n) {
				return i;
			}
		}
		return -1;
	}
	
	static int largestElement(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	static int sumOfElements(int[] arr) {
		int sum = 0;
		for(int i = 0; i <arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array: ");
		
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		
		System.out.println("Enter the elements of the array: ");
		
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("The largest element of the array is: "+ largestElement(arr));
		System.out.println("The sum of elemrnts of the array is: "+ sumOfElements(arr));
		System.out.println("Enter the elements to search: ");
		int key = sc.nextInt();
		System.out.println("The element "+ key+ " is at " + searchElement(key, arr)+ " index");
		
	}

}
