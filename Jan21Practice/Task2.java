package Jan21Practice;

class Employee{
	private static Employee instance;
	
	private Employee() {
		System.out.println("Student object created;");
	}
	
	public static Employee getInstance() {
		if(instance == null) {
			instance = new Employee();
		}
		return instance;
	}
}

public class Task2 {

	public static void main(String[] args) {
		Employee s1 = Employee.getInstance();
		Employee s2 = Employee.getInstance();
		
		System.out.println(s1 == s2);

	}

}
