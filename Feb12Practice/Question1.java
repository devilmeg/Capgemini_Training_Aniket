package Feb12Practice;

import java.util.*;

class Student{
	int rollNo;
	String name;
	int marks;
	
	public Student(int rollNo, String name, int marks){
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}
}

public class Question1 {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		
		students.add(new Student(3, "Manas", 90));
		students.add(new Student(1, "Aman", 85));
		students.add(new Student(2, "Rohit", 95));
		
		Comparator
		
		for(Student student: students) {
			System.out.println(student.name+ " " + student.rollNo + " " + student.marks);
			
		}
	}

}
