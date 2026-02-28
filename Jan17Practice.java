abstract class Employee{
	String name;
	int id;
	
	Employee(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	void showDetails() {
		System.out.println("This is the detail for: "+ name);
	}
	
	abstract double calculateSalary();
}

class Developer extends Employee{
	Developer(String name, int id){
		super(name, id);
	}
	double calculateSalary() {
		return 50000+20000;
	}
}

class Manager extends Employee{
	Manager(String name, int id){
		super(name, id);
	}
	
	double calculateSalary() {
		return 70000+20000;
	}
}

public class Jan17Practice {
	public static void main(String []args) {
		Employee e1 = new Developer("Manas", 101);
		e1.showDetails();
		System.out.println("The salary of "+ e1.name+ " is: $"+ e1.calculateSalary());
		
		Employee e2 = new Manager("Chanitanya", 202);
		e2.showDetails();
		System.out.println("The salary of "+ e2.name+ " is: $"+ e2.calculateSalary());
	}
}
