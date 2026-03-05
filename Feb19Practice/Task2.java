package Feb19Practice;

import java.io.*;

public class Task2 {

	public static void main(String[] args) {
		File f = new File("demo.txt");
		
		try {
			System.out.println(f.createNewFile());
		}catch(Exception e) {
			
		}
		
		try {
			FileWriter fw = new FileWriter(f);
			
			String s = "java";
			
			fw.write(s);
			fw.close();
		}catch(Exception e) {
			
		}
	}

}
