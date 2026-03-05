package Feb20Practice;

import java.util.*;

//Comparator and Comparable both are functional interface

//class Job implements Comparable<Job>{
//	
//	private int priority;
//	private String title;
//	private double salary;
//	
//	Job(int priority, String title, double salary){
//		this.priority=priority;
//		this.title=title;
//		this.salary=salary;
//	}
//
//	@Override
//	public int compareTo(Job o) {
//		return this.priority-o.priority;
//	}
//	
//	@Override
//	public String toString() {
//		return priority + " "+  title + " "+ salary;
//	}
//	
//}

class A {
	public Object m1() {
		return 1;
	}
}

class B extends A{
	public Double m1() {
		return 2.00;
	}
}


public class Task1 {

	public static void main(String[] args) {
//		List<Job> list = new ArrayList<>();
//		
//		list.add(new Job(2, "Developer", 4500.00));
//
//		list.add(new Job(1, "MLEngineer", 7700.00));
//
//		list.add(new Job(3, "Analyst", 5500.00));
//		
//		Collections.sort(list);
//		
//		for(Job job: list) {
//			System.out.println(job);
//		}
		
//		B b = new B();
//		A a = new A();
//		
//		Object o = a.m1();
//		System.out.println(o);
//		double s = b.m1();
//		System.out.println(s);
		
		System.out.println(10.0/0+"∞");
	}

}
