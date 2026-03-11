package Task2;
import jakarta.persistence.*;

import Task2.dao.StudentDao;
import Task2.dao.StudentDaoImpl;

public class Student_Laptop_Application {

    public static void main(String[] args) {

        StudentDao dao = new StudentDaoImpl();

        // 1️  ********** Insert 6 Records first
//        dao.saveData();

        // 2️  ********** Fetch laptop using student id
     //   dao.fetchLaptopFromStudent(1);

        // 3️  ********** Fetch student using laptop id
      //  dao.fetchStudentFromLaptop(4);

        // 4️  ********** Update laptop brand
//        dao.updateLaptopBrand(2, "MSI");

        // 5️  ********** Update student course
        //dao.updateStudentCourse(1, "AI & ML");

        // 6️  ********** Change laptop for student
//        dao.changeLaptopForStudent(4, 12);

        // 7️  ********** Remove laptop from student
         dao.removeLaptopFromStudent(2);

        // 8️  ********** Delete student and laptop
        // dao.deleteStudentAndLaptop(2);

        System.out.println("All DAO operations executed successfully.");
    }
}