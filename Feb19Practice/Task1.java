package Feb19Practice;

import java.io.File;

// classes in java.io --> File, FileReader, FileWriter, FileOutputStream, FileInputStream, ObjectOutputStream, ObjectInputStream

// File: 
// mkdir()-> create directory
// createNewFile()-> creates a new file
// 

public class Task1 {

	public static void main(String[] args) {
//		File f = new File("test");
//		
//		File f2 = new File("test.txt");
		
//		String path = "C:\\Users\\manas\\Desktop\\6th sem\\folder2";
//		
//		File f3 = new File(path);
//		
//		System.out.println(f3.mkdir());
		
		String path2 = "C:\\\\Users\\\\manas\\\\Desktop\\\\6th sem\\file1.txt";
		
		File f4 = new File(path2);
		
		try {
			System.out.println(f4.createNewFile());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
//		File f1 = new File("test1");
//		
//		File f2 = new File("Test123");
//		
//		System.out.println(f.mkdir());
//		
//		try {
//			System.out.println(f2.createNewFile());
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
    }

}
