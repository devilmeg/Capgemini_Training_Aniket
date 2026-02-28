//Take long text as input and find the top 3 most frequent words+
package Feb4Practice;

class Answer{
	static int subarrayWithSumK(int arr[], int k) {
		int size = arr.length;
		
		int i = 0; 
		int j = 0;
		int sum = 0;
		int length = 0;
		
		while(j < size) {
			if(sum < k) {
				sum = sum+arr[j];
				j++;
			}else if(sum > k) {		
				length = j-i+1;
				i++;
			}else {
			    if((j-i+1) > length) {
			    	length = j-i+1;
			    }
				i++;
			}
			j++;
		}
		
		return length;
	}
}

public class Question2 {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 0, 1, 0, 2, 4};
		int k = 5;
		
		int answer = Answer.subarrayWithSumK(arr, k);
		
		System.out.println(answer);
	}

}
