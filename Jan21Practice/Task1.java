package Jan21Practice;

class Student{
	private int id;
	private String name;
	
	private Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//public factory method to keep constructor private and that method internally calls the constructor from that method
	public static Student createStudent(int id, String name) {
		return new Student(id, name);
	}
	
	public void printName() {
		System.out.println("Name: "+ name);
	}
}

public class Task1 {

	public static void main(String[] args) {
		Student st = Student.createStudent(1, "Manas");
		st.printName();
		
		
		
	}
}
