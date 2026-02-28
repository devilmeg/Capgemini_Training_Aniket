
public class Operators {

	public static void main(String[] args) {
		
		int a = 12;
		int b = 3;
		
		//Arithmetic operators
		System.out.println("Arithmetic operators: ");
		System.out.println(a+b); //15
		System.out.println(a-b); //9
		System.out.println(a/b); //4
		System.out.println(a%b); //0
		System.out.println(a*b); //36
		System.out.println(Math.pow(a, b)); //1728
		
		//Logical Operators
		System.out.println(true && true); // true
		System.out.println(true && false); //false
		System.out.println(true || false); //true
		System.out.println(false || false);//false
		System.out.println(!true); //false
		System.out.println(!false); //true
		
		//Relational Operators
		System.out.println(a>b); //true
		System.out.println(a<b); //false
		System.out.println(a==b); //false
		
		//Assignment Operators
		int c = 5; //assigned 5 to variable c
		System.out.println(c); //5
		
		//Ternary operator
		String result = (a>b)? "Greater" : "Lesser";
		System.out.println(a + " is "+ result + " than "+ b);

	}

}
