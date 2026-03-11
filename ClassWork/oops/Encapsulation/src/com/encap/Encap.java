package com.encap;

class Student{
	private  int age ;
	
	public  void setter(int a) {
		this.age=a;
	}
	
	public int getter() {
		return age ;
	}
	
	
}
public class Encap {
public static void main(String args[]) {
	Student s = new Student();
    s.setter(22);
	System.out.println(s.getter());
}
}
