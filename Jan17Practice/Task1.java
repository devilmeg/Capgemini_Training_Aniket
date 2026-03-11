package Jan17Practice;

abstract class Shape{
	String name;
	
	Shape(String name){
		this.name = name;
	}
	
	abstract double area();
	abstract double perimeter();
}

class Circle extends Shape{
	int radius;
	
	Circle(int radius){
		super("Circle");
		this.radius = radius;
	}
	
	double area() {
		return Math.PI*radius*radius;
	}
	
	double perimeter() {
		return 2*Math.PI*radius;
	}
}

class Square extends Shape{
	int length;
	
	Square(int length){
		super("Square");
		this.length = length;
	}
	
	double area() {
		return length*length;
	}
	
	double perimeter() {
		return length*4;
	}
}

public class Task1 {

	public static void main(String[] args) {
		Shape c = new Circle(2);
		Shape s = new Square(4);
		
		System.out.println(c.name + " area = " + c.area());
        System.out.println(c.name + " perimeter = " + c.perimeter());
		
        System.out.println(s.name + " area = " + s.area());
        System.out.println(s.name + " perimeter = " + s.perimeter());
	}

}
