package Feb18Practice;

import java.util.Arrays;
import java.util.Stack;

class NextGreaterElement{
	public static int[] nextGreater(int[] nums) {
		int size = nums.length;
		
		int[] ans = new int[size];
		
		Arrays.fill(ans, -1);
		
		Stack<Integer> st = new Stack<>();
		
		st.push(nums[size-1]);
		
		for(int i = size-2; i >= 0; i--) {
			if(nums[i] < st.peek()) {
				ans[i] = st.peek();
				st.push(nums[i]);
			}else {
				while(!st.isEmpty() && st.peek() <= nums[i]) {
					st.pop();
				}
				if(!st.isEmpty()) {
					ans[i] = st.peek();
					st.push(nums[i]);
				}else {
					st.push(nums[i]);
				}
				
			}
		}
		return ans;
	}
}

public class Question3 {

    public static void main(String[] args) {

        int[] nums = {2, 1, 2, 4, 3,8,3};

        int[] result = NextGreaterElement.nextGreater(nums);

        System.out.println("Input Array:");
        System.out.println(Arrays.toString(nums));

        System.out.println("Next Greater Elements:");
        System.out.println(Arrays.toString(result));
    }
}

