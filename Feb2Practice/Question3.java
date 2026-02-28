package Feb2Practice;

public class Question3 {

	public static void main(String[] args) {
		int arr[] = {2, 8, 5, 5, 2, 5,};
		
		int size = arr.length;
		
		int count = 0;
		
		boolean flag[] = new boolean[size]; 
		
		for(int i = 0; i < size; i++) {
			if(flag[i]) continue;
			
			for(int j = i+1; j < size; j++) {
				if (flag[j] == false && arr[i] + arr[j] == 10) {
						count = count+1;
						flag[i] = true;
						flag[j] = true;
						break;	
				}
			}
		}
		
		System.out.println(count);

	}

}
