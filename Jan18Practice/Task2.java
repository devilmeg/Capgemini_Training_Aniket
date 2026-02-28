package Jan18Practice;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

	public static void main(String[] args) {
		List<String> users = new ArrayList<>();
		
		users.add("Manas");
		users.add("Rishabh");
		users.add("Shivam");
		
		System.out.println("Second user: " + users.get(1));
//		users.remove("Shivam");
		System.out.println("Users: "+ users);
	}

}
