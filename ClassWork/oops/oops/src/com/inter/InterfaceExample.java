package com.inter;

interface A {
	public void m1();
	
//	public void m2();
//	
//	public void m3();
	
	default  void m4() {
		System.out.println("default method");
		
	}
}

class B implements A {

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		System.out.println("method of B");
		
	}
//
//	@Override
//	public void m2() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void m3() {
//		// TODO Auto-generated method stub
//		
//	}


	
}

class C implements A {

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		System.out.println("method of C");
		
	}

//	@Override
//	public void m2() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void m3() {
//		// TODO Auto-generated method stub
//		
//	}
}
public class InterfaceExample   {

	
	
public static void main(String args[] ) {
	A obj1 = new B();
	obj1.m1();
	
	A a = new A() {
		@Override
		public void m1() {
			// TODO Auto-generated method stub
			System.out.println("method of main class ");
		}	
	};
	a.m1();
}
	
}

	


