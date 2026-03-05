package Jan18Practice;

public class Task1 {

	public static void main(String[] args) {
        String user = "Manas";
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Hello! ")
		  .append(user)
		  .append(" How are you!!");
		
		String message = sb.toString();
		
		System.out.println(message);

	}

}
