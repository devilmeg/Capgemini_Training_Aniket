package M1Practice;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class RemoveDuplicates{
	public static List<Integer> removeDuplicates(List<Integer> nums){
		List<Integer> result= new ArrayList<>();
		Set<Integer> set1 = new HashSet<>();
		
		set1.addAll(nums);
		
		result.addAll(set1);
		
		return result;
		
	}
}

public class Question1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(4);
		list.add(4);
		
		System.out.println(RemoveDuplicates.removeDuplicates(list));
		

	}

}
