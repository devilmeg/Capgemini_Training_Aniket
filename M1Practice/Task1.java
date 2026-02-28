package M1Practice;

import java.io.*;

//call the non static readline method of the bufferedreader class
// How to work with an abstract class
// --> By creating a child class


public class Task1 {

	public static void main(String[] args) throws IOException {
//		Reader reader = new Reader();//cannot instantiate the type reader beacuse this is an abstract class
		try {
			FileReader fr = new FileReader("Manas");
		}catch(Exception e) {
			System.out.println("File not found!!");
		}
		
		InputStream input1 = System.in;
				
		InputStreamReader input = new InputStreamReader(input1);
		
		BufferedReader reader1 = new BufferedReader(input);
		
		reader1.readLine();
	}

}
