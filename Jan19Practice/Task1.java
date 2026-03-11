//Collection Implementation

package Jan19Practice;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.TreeSet;


public class Task1 {

	public static void main(String[] args) {
		
		//List implementation
		
		//Linked list implementation
		
		LinkedList<String> tasks = new LinkedList<>();
		
		tasks.addFirst("Critical Fix");
		tasks.addLast("Second Task");
		tasks.addFirst("Last Task");
		
		System.out.println("Next Task: " + tasks.removeFirst());
		
		System.out.println("Tasks: "+ tasks);		
		
		//HashSet Implementation
		
		Set<String> email = new HashSet<>();
		
		email.add("manassingh@gmail.com");
		email.add("manassingh@gmail.com");
		email.add("manas@gmail.com");
		email.add("manas@gmail.com");
		email.remove("manas@gmail.com");
		
		System.out.println("Emails: "+ email);
		
		//LinkedHashSet Implementation
		
		Set<Integer> nums = new LinkedHashSet<>();	
		
		nums.add(10);
		nums.add(30);
		nums.add(20);
		nums.add(15);
		nums.add(30);
		
		System.out.println("Numbers before removeing: "+ nums);
		
		nums.remove(20);
		
		System.out.println("Numbers after removeing: "+ nums);
		
		//TreeSet Implementation
		
		Set<Integer> ages = new TreeSet<>();
		
		ages.add(30);
		ages.add(25);
		ages.add(30);
		ages.add(40);
		
		System.out.println(ages.isEmpty());
		
		System.out.println(ages.contains(20));
		
		System.out.println("Size of the treeset: "+ ages.size());
		
		System.out.println("Ages before removeing: "+ ages);
		
		//System.out.println(ages.first());//only belongs to TreeSet class, so if TreeSet object is made , this method is okay to use
			
		
	}

}
