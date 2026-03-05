//using ternary operators find the greatest number among three
public class Question1 {

	public static void main(String[] args) {
		int a = 12;
		int b = 7;
		int c = 3;
		
		int result = (c > ((a>b)? a : b))? c : (a>b)? a : b ;
		
		System.out.println(result);
		
	}

}
