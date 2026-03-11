package in.main;

class Student{
	static Student s = new Student();
	
	String name;
	
	private Student() {
		System.out.println("Constructor calling...");
	}
	
	public static Student getInstance(String name) {
		s.name = name;
		return s;
	}
	
}

public class Singleton {
	public static void main ( String args[] ) {
		Student s1 = Student.getInstance("Aakanshi");
		System.out.println(s1.name);
		Student s2 = Student.getInstance("Aakanshi");
		System.out.println(s2.name);
	}
	
	
}
