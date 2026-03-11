package Feb6Practice;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Question3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<String> history = new ArrayList<>();
        
        String currentPage = null;
        
        while(true) {
        	System.out.print("\nEnter command: ");
            String input = sc.nextLine().toLowerCase();
            
            if (input.equals("exit")) {
                System.out.println("Browser closed.");
                break;
            }
            
            
        }
		
		

	}

}
