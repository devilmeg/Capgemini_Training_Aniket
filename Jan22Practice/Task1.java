package Jan22Practice;

class Parent{
	String name;
    int age;
    static int id;
    
    public Parent(String name, int age) {
    	this.name = name;
    	this.age = age;
    }
    
    static void func1() {
    	System.out.println("This is static function of class A");
    }
    
    public static void func2() {
    	System.out.println("This is public static function of class A");
    }
}

class Child extends Parent{
	
	public Child(String name, int age) {
		super(name, age);
	}

	static void func1() {
		System.out.println("This is static function from parent overriden");
	}
	
	public static void func3(int id) {
		Child.id = id;
		System.out.println(id);
	}
}

public class Task1 {

	public static void main(String[] args) {
		
		Child c = new Child("Manas", 21);
		
		c.func3(20);
		
		System.out.println("Id: "+ Child.id+ " Parent "+ Parent.id);
		
	    c.func2();
		c.func1();

	}

}
