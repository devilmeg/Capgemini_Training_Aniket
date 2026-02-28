package Jan19Practice;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;

public class Task2 {

	public static void main(String[] args) {
//		Map<Integer, String> users = new HashMap<>();
//		
//		users.put(1, "Manas");
//		users.put(2, "Shivam");
//		users.put(3, "Rishabh");
//		
//		System.out.println(users.get(2));
		
		Map<String, Integer> scores = new LinkedHashMap<>();
		
		scores.put("Rishabh", 98);
		scores.put("Manas", 56);
		scores.put("Rishabh", 67);
		
		System.out.println(scores.get("Rishabh"
				+ ""));
	}

}
