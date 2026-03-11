import java.util.Scanner;

public class ControlStatement1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter you age: ");
		int age = sc.nextInt();
		
		if(age >= 18) {
			
			System.out.println("Do you have a driving licence: Enter true or false");
			boolean hasLicence = sc.nextBoolean();
			
			if(hasLicence) {
				System.out.println("You can drive");
			}else {
				System.out.println("Go get a licence first");
			}
		}else {
			System.out.println("wait until you're 18");
		}
		
		
	    System.out.print("What is the day today? ");
		
		String day  = sc.next();
		
		switch(day) {
		    case  "Monday":
			    System.out.println("Huh! Just started the weekend");
			    break;
		    case "Tuesday":
		    	System.out.println("Today is Tuesday");
		    	break;
		    case "Wednesday":
		    	System.out.println("Today is Wednesday");
		    	break;	
		    case "Thursday":
		    	System.out.println("2 more days to go ! keep going!");
		    	break;
		    case "Friday":
		    	System.out.println("Just weekend !");
		    	break;	
		    default:
		    	System.out.println("Woohoo!! Weekends!!");
		}

	}

}
