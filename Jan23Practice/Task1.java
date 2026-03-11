package Jan23Practice;

class A{
	public void m1() {
		System.out.println("This is M1");
	}
}

class B extends A{
	public void m2() {
		System.out.println("This is M2");
	}
}

public class Task1 {
	public static void main(String []args) {
		A a = new B();
		
		B b = (B)a;
		
	}
}
