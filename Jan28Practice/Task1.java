package Jan28Practice;

class Student{
	String name;
	int id;
	
	public Student(String name, int id){
		this.name = name;
		this.id = id;
	}
	
}

public class Task1 {

	public static void main(String[] args) {
		Student s1 = new Student("Manas", 1);
		Student s2 = new Student("Om", 2);
		
		
		
		System.out.println(s1.equals(s2));

	}

}
