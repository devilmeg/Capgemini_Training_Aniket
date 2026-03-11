package in.main;

class Car {
	String brand;
	int id ;
	
//	// default constructor 
//	Car (){
//		System.out.println("This is a brand new car");
//	}
//	
//	// parameterized constructor 
//	Car (String brand, int id ){
//		System.out.println("car brand is: " + brand);
//		System.out.println("Its number is: " + id );
//		
//	}
	Car(){
		this("toyota", 123);
		System.out.println("This is a brand new car");
	}
	Car(String brand, int id ){
		this.brand=brand;
		this.id=id;
		System.out.println("car brand is: " + brand);
		System.out.println("Its number is: " + id );
		
	}
	
}

public class Main {
	public static void main(String args[]) {
		Car c = new Car();
//		Car c1 = new Car ("Toyota", 123);
		
	}

}
